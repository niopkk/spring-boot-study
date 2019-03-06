package com.bbz.server;


import com.bbz.service.MessageService;
import com.bbz.service.impl.MessageServiceImpl;

import java.io.IOException;

public class IOServer {


    public static void main(String[] args) throws IOException {

        new Thread(()->{
            RpcServer serviceServer = new ServiceCenter(8088);
            serviceServer.register(MessageService.class, MessageServiceImpl.class);
            try {
                serviceServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
