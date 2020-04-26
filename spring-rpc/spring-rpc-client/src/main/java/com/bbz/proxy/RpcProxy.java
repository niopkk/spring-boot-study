package com.bbz.proxy;

import com.bbz.annotation.RpcClient;
import com.bbz.pojo.Request;
import com.bbz.util.Jsons;
import com.bbz.util.Strings;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.ExportException;

public class RpcProxy implements InvocationHandler {

    private Class<?> classType;

    private InetSocketAddress addr;


    public RpcProxy(Class<?> classType, InetSocketAddress addr) {
        this.classType = classType;
        this.addr = addr;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IOException {
//        Socket socket = null;
//        BufferedReader br = null;
//        PrintWriter pw = null;

        try (Socket socket = new Socket()) {
            socket.connect(this.addr);
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    //注意首先向服务端发送消息,再接收服务端返回的信息,不要写反了
                    Request request = new Request();
                    request.setClassName(this.classType.getSimpleName());

                    if (!method.isAnnotationPresent(RpcClient.class)) {
                        throw new NullPointerException("方法[" + method + "]没有RpcClient注解");
                    }
                    RpcClient annotation = method.getAnnotation(RpcClient.class);
                    request.setMethodName(annotation.value());
                    request.setParamsType(method.getParameterTypes());
                    request.setParams(args);

                    pw.println(Jsons.toJson(request));
                    pw.flush(); //flush()一般用于处理中时需要将数据立即写出。将缓冲区的内容输出
                    String str = br.readLine();
                    return str;
                }
            }
        }
    }
}
