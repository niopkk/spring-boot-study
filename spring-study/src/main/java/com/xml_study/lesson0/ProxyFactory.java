package com.xml_study.lesson0;

import java.lang.reflect.Proxy;

public class ProxyFactory {


    public <T> T proxy(Class<?> classType) {

        System.out.println("classType:" + classType);

        System.out.println("new():" + new HelloWorldImpl());
        return (T) Proxy.newProxyInstance(classType.getClassLoader(), new Class<?>[]{classType},
                new RpcProxy(new HelloWorldImpl()));
    }
}
