package com.bbz.proxy;

import com.bbz.pojo.Request;
import com.bbz.util.Jsons;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RpcProxyFacotry implements InvocationHandler {


    private Class<?> classType;

    private InetSocketAddress addr;


    public <T> T proxy(final Class<?> classType, final InetSocketAddress addr) {
        this.classType = classType;
        this.addr = addr;
        return (T) Proxy.newProxyInstance(
                this.classType.getClassLoader()
                , new Class<?>[]{this.classType}
                , this
        );
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            // 2.创建Socket客户端，根据指定地址连接远程服务提供者
            socket = new Socket();
            socket.connect(this.addr);
            //用于发送给server端的信息
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            //用于接收Server端发来的信息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // for (int i = 0; i < 10; i++) {
            //注意首先向服务端发送消息,再接收服务端返回的休息,不要写反了
            Request request = new Request();
            request.setClassName(this.classType.getName());
            request.setMethodName(method.getName());
            request.setParamsType(method.getParameterTypes());
            request.setParams(args);

            pw.println(Jsons.toJson(request));
            pw.flush(); //flush()一般用于处理中时需要将数据立即写出。将缓冲区的内容输出
            String str = br.readLine();
//            System.out.println("拿到server返回的消息:" + str);
            return str;

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
