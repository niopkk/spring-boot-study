package com.bbz.server;

import com.bbz.pojo.Request;
import com.bbz.pojo.Respone;
import com.bbz.util.Jsons;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

public class ServiceTask implements Runnable {

    /**
     * 读取流
     */
    private BufferedReader br;
    /**
     * 写入流
     */
    private PrintWriter pw;

    private Socket client;

    private Map<String, Class<?>> serviceRegistry;


    public ServiceTask(Socket socket, Map<String, Class<?>> serviceRegistry) {
        this.client = socket;
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    public void run() {

        try {
            //注意此处得到的socket的输入流为socket的输入流即上方的(private Socket socket = null; )
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //向客户端返回消息的PrintWriter对象
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            String str = br.readLine();
            System.out.println("客户端传入:" + str);
            Request request = Jsons.fromJson(str, Request.class);

            Respone respone = invokeMethod(request);

            pw.println(Jsons.toJson(respone));
            pw.flush();
        } catch (Exception e) {
            try {
                br.close();
                pw.close();
                client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private Respone invokeMethod(Request request) throws ClassNotFoundException {
        String serviceName = request.getClassName();
        Class<?> serviceClass = serviceRegistry.get(serviceName);
        if (serviceClass == null) {
            throw new ClassNotFoundException(serviceName + " not found");
        }
        Respone response = new Respone();
        try {
            Method method = serviceClass.getMethod(request.getMethodName(), request.getParamsType());

            System.out.println("serviceClass:" + serviceClass);
            System.out.println("serviceClassnewInstance:" + serviceClass.newInstance());
            Object result = method.invoke(serviceClass.newInstance(), request.getParams());


            response.setResult(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return response;
    }


}
