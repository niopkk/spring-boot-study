package com.bbz.core;

import com.bbz.exception.MethodNotHaveRPCAnnotation;
import com.bbz.annotation.RPCmethod;
import com.bbz.exception.RPCProxyReadOutTimeException;
import com.bbz.util.Jsons;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RPCProxy {

    /**
     * 远程服务ip
     */
    private String serverIp;

    /**
     * 端口
     */
    private int port;

    /**
     * 超时时间
     */
    private int waitingTime;

    public RPCProxy(String serverIp, int port, int waitingTime) {
        this.serverIp = serverIp;
        this.port = port;
        this.waitingTime = waitingTime;
    }
//
//    public <T> T getProxy(Object o) {
//
//        return getProxy(o.getClass());
//    }

    public <T> T getProxy(Class<T> cla) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cla);
//        enhancer.setInterfaces(cla.getClass().getInterfaces());
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {

            if (!method.isAnnotationPresent(RPCmethod.class)) {
                throw new MethodNotHaveRPCAnnotation("方法[" + method + "]没有RPCmethod.class的注解");
            }
            RPCmethod rpCmethod = method.getAnnotation(RPCmethod.class);


            String remoteName = rpCmethod.remoteName();
            List<String> paramers = new ArrayList<>();
            int paramerCount = objects.length;
            for (int i = 0; i < paramerCount; i++) {
                paramers.add(Jsons.toJson(objects[i]));
            }

            Socket socket = new Socket(serverIp, port);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Object lock = new Object();
            ControlThread controlThread = new ControlThread(dataInputStream, dataOutputStream, lock);
            synchronized (lock) {
                new Thread(controlThread).start();
                lock.wait();
            }
            //首先发送远程调用方法的remoteName
            dataOutputStream.writeUTF(remoteName);
            if (paramerCount > 0) {
                //序列化为json字符串
                String str = Jsons.toJson(paramers);
                byte[] bytes = str.getBytes();
                dataOutputStream.writeInt(bytes.length);
                //将字符串转换为二进制发送，需先发送一个头部表明需要接收的长度
                dataOutputStream.write(bytes);
            }
            Object result = null;
            try {
                int length = dataInputStream.readInt();
                byte[] bytes = new byte[length];
                dataInputStream.readFully(bytes, 0, length);
                String resStr = new String(bytes);
                if (resStr.equals("null")) {
                    return null;
                }
                result = Jsons.fromJson(resStr.trim(), method.getGenericReturnType());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RPCProxyReadOutTimeException("向服务器【" + serverIp + "】请求数据超时");
            } finally {
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
            }
            return result;

        });
        Object cglibProxy = enhancer.create();
        return (T) cglibProxy;
    }

    public class ControlThread implements Runnable {

        private DataInputStream dataInputStream;

        private DataOutputStream dataOutputStream;

        private Object lock;

        public ControlThread(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Object lock) {
            this.dataInputStream = dataInputStream;
            this.dataOutputStream = dataOutputStream;
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {
                lock.notify();
            }
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                synchronized (dataInputStream) {
                    dataInputStream.close();
                }
                synchronized (dataOutputStream) {
                    dataOutputStream.close();
                }
            } catch (IOException e) {

            }


        }
    }

}
