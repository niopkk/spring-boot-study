package com.bbz.test;

import com.bbz.core.RPCProxy;

public class ClientTest {

    public static void main(String[] args) {
        RPCProxy localProxy = new RPCProxy("127.0.0.1", 54196, 5000);
        Student student = localProxy.getProxy(Student.class);
        System.out.println(student.getName());
    }
}
