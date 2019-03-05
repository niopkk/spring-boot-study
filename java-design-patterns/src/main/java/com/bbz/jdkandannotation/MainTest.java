package com.bbz.jdkandannotation;

public class MainTest {


    public static void main(String[] args) {


        ISing o = new ProxyFactory().newMapperProxy(ISing.class);
        System.out.println(o.add("dds"));
    }
}
