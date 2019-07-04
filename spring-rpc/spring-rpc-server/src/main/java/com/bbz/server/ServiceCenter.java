package com.bbz.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServiceCenter implements RpcServer, RegistryBean {


//    ThreadPoolExecutor
//    new ThreadPoolExecutor(5,200,0L,)
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 注入iop
     */
    private final static Map<String, Class<?>> serviceRegistry = new ConcurrentHashMap<>();


    private int port;

    public ServiceCenter(int port) {
        this.port = port;
    }


    @Override
    public void stop() {
        executor.shutdown();
    }

    @Override
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("开始执行start.........");

        try {
            while (true) {
                //线程池取运行
                executor.execute(new ServiceTask(serverSocket.accept(), serviceRegistry));
            }
        } finally {
            serverSocket.close();
        }

    }

    @Override
    public void register(Class<?> serviceInterface, Class<?> impl) {
//        已注入的bean不能重复注入
        if (!serviceRegistry.containsKey(serviceInterface.getSimpleName())) {
            serviceRegistry.put(serviceInterface.getSimpleName(), impl);
        }
    }

}
