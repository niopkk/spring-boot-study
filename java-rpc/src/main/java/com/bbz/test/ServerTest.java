package com.bbz.test;

import com.bbz.core.RPCServer;

import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) {
        RPCServer rpcServer = new RPCServer();
        Student student = new Student();
        student.setName("小绿");
        rpcServer.scanPackage("com.bbz.test");
        rpcServer.addService(student);
        try {
            rpcServer.start(54196);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
