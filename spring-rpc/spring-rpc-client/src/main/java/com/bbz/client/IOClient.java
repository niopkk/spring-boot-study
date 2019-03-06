package com.bbz.client;

import com.bbz.proxy.RpcProxyFacotry;
import com.bbz.service.MessageService;

import java.io.IOException;
import java.net.InetSocketAddress;

public class IOClient {

    public static void main(String[] args) throws IOException {


        MessageService messageService =
                new RpcProxyFacotry().proxy(
                        MessageService.class,
                        new InetSocketAddress("127.0.0.1", 8088));

        System.out.println(messageService.say());
        System.out.println(messageService.say("李四"));

    }
}
