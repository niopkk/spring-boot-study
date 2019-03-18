package com.xml_study.lesson5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lesson5.xml");

        HelloWorld world = (HelloWorld) context.getBean("helloword");

        System.out.println(world.getMessage());

        context.registerShutdownHook();
    }
}
