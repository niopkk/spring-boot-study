package com.bbz.jdkandannotation;

public class MainTest {


    public static void main(String[] args) throws ClassNotFoundException {



        ISing o = new ProxyFactory().newMapperProxy(ISing.class);
        System.out.println(o.add("dds"));
    }
}
