package com.bbz.server;


import com.bbz.serviced.MessageService;
import com.bbz.serviced.impl.MessageServiceImpl;

import java.io.IOException;

public class IOServer {


    public static void main(String[] args) throws IOException {

        new Thread(() -> {
            ServiceCenter serviceServer = new ServiceCenter(8088);
            serviceServer.register(MessageService.class, MessageServiceImpl.class);
            try {
                serviceServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
