package com.lesson10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson10.xml");

        JavaCollection collection = (JavaCollection) context.getBean("javaCollection");

        System.out.println(collection.getList());
        System.out.println(collection.getMap());
        System.out.println(collection.getProperties());
        System.out.println(collection.getSet());


    }
}
