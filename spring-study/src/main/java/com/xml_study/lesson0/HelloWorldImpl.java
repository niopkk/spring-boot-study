package com.xml_study.lesson0;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String say() {
        System.out.println("hello world");
        return "hello world";
    }
}
