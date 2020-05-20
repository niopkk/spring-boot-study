package com.bbz.core;

import com.bbz.annotation.RPCmethod;
import com.bbz.annotation.RpcClass;
import com.bbz.exception.ClassNotHaveRPCAnnotation;
import com.bbz.exception.RPCMethodParametersLengthMismatching;
import com.bbz.exception.RPCServiceNotRegister;
import com.bbz.exception.RPCServiceObjectNotLoad;
import com.bbz.util.Jsons;
import com.bbz.util.PackageScanner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RPCServer implements Runnable {


    //用来装可以被远程调用的方法
    private Map<String, RPCMethodDefinition> serviceMap;
    //控制服务器侦听客户端线程的变量
    private volatile boolean goon;
    private ServerSocket serverSocket;

    //用来得到传过来的实参
    private static Type type;

    public RPCServer() {
        serviceMap = new HashMap<>();
        goon = false;
    }

    //启动RPC服务器
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        goon = true;
        new Thread(this).start();
    }

    //关闭服务器
    public void stop() {
        if (serverSocket == null || serverSocket.isClosed()) {
            return;
        }
        goon = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket = null;
        }
    }


    //服务器主线程，侦听到就启动一个线程去处理RPC请求
    public void run() {
        while (goon) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(new DealRequest(socket)).start();
            } catch (IOException e) {
                if (goon) {
                    e.printStackTrace();
                } else {
                    break;
                }
            }
        }
    }


    //处理远程掉用的请求并返回结果
    private class DealRequest implements Runnable {
        private Socket socket;
        private DataOutputStream dos;
        private DataInputStream dis;

        public DealRequest(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //这里的读和写与RPCProxy写和读一一对应
        public void run() {
            try {
                //读取远程调用的remoteName
                String remoteName = dis.readUTF();
                //从RPC服务集合里取出对应的RPCMethodDefinition
                RPCMethodDefinition rdf = serviceMap.get(remoteName);
                if (rdf == null) {
                    throw new RPCServiceNotRegister("服务" + remoteName + "未注册");
                }

                Object object = rdf.getObject();

                if (object == null) {
                    throw new RPCServiceObjectNotLoad("服务" + remoteName + "对象未加载");
                }

                Method method = rdf.getMethod();
                Type[] parameters = method.getGenericParameterTypes();
                int parameterCount = parameters.length;
                Object result = null;

                if (parameterCount <= 0) {
                    //如果参数为0，直接反射执行该方法
                    result = method.invoke(object);
                } else {
                    //如果参数不为0.先接收序列化的实参，再进行反序列化
                    int length = dis.readInt();
                    byte[] bytes = new byte[length];
                    dis.readFully(bytes, 0, length);
                    String parameter = new String(bytes);
                    ArrayList<String> parameterList = Jsons.fromJson(parameter, type);
                    if (parameterCount != parameterList.size()) {
                        throw new RPCMethodParametersLengthMismatching("服务" + remoteName + "参数个数不匹配" + parameterCount + " " + parameterList.size());
                    }

                    Object[] argus = new Object[parameterCount];

                    for (int i = 0; i < parameterCount; i++) {
                        argus[i] = Jsons.fromJson(parameterList.get(i), parameters[i]);
                    }
                    result = method.invoke(object, argus);

                }

                byte[] bytes = Jsons.toJson(result).getBytes();
                dos.writeInt(bytes.length);
                dos.write(bytes);
                //确认数据全部发送完毕之后关闭相应资源
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (RPCServiceNotRegister rpcServiceNotRegister) {
                rpcServiceNotRegister.printStackTrace();
            } catch (RPCServiceObjectNotLoad rpcServiceObjectNotLoad) {
                rpcServiceObjectNotLoad.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (RPCMethodParametersLengthMismatching rpcMethodParametersLengthMismatching) {
                rpcMethodParametersLengthMismatching.printStackTrace();
            } finally {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //自动扫描指定包下的所有类，当检测到带有RPCclass注解的类时实行自动装入
    public void scanPackage(String path) {
        //自制的包扫描工具，可以遍历指定包下的所有类
        new PackageScanner() {
            public void dealClass(Class<?> klass) {
                try {
                    if (klass.isAnnotationPresent(RpcClass.class)) {
                        addService(klass);
                    }
                } catch (ClassNotHaveRPCAnnotation classNotHaveRPCAnnotation) {
                    return;
                }
            }
        }.packageScanner(path);
    }

    //提供给外部增加RPCmethod的方法，参数为object时，表明该object是其调用对应类的方法时要反射执行方法的对象
    public void addService(Object object) throws ClassNotHaveRPCAnnotation {
        Class klass = object.getClass();

        if (!klass.isAnnotationPresent(RpcClass.class)) {
            throw new ClassNotHaveRPCAnnotation("class[" + klass + "]没有RPCclass注解");
        }

        addService(klass, object);
    }

    //若只给一个Class对象，如果该对象是自动装载，则自动创造一个新的对象，若该对象是另外装入，则RPCMethodDefinition里的object暂为null
    public void addService(Class klass) throws ClassNotHaveRPCAnnotation {
        if (!klass.isAnnotationPresent(RpcClass.class)) {
            throw new ClassNotHaveRPCAnnotation("class[" + klass + "]没有RPCclass注解");
        }

        RpcClass rpCclass = (RpcClass) klass.getAnnotation(RpcClass.class);
        try {
            Object object = rpCclass.auto() ? klass.newInstance() : null;
            addService(klass, object);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void addService(Class klass, Object object) {
        Method[] methods = klass.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(RPCmethod.class)) {
                continue;
            }

            RPCmethod rpcMethod = method.getAnnotation(RPCmethod.class);
            String remoteName = rpcMethod.remoteName();
            RPCMethodDefinition rdf = serviceMap.get(remoteName);
            //若rdf不为null，则表明是延迟加载的对象，只需设置对应的object就可以
            if (rdf != null) {
                rdf.setObject(object);
                continue;
            }
            serviceMap.put(remoteName,
                    new RPCMethodDefinition()
                            .setKlass(klass)
                            .setMethod(method)
                            .setObject(object));

        }
    }


}
