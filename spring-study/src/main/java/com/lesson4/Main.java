package com.lesson4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson4.xml");

        HelloWord helloWordA = (HelloWord) context.getBean("helloWorld");

        helloWordA.setMessage("wo de ce shi yi er ");

        System.out.println(helloWordA.getMessage());

        HelloWord helloWordB = (HelloWord) context.getBean("helloWorld");

        System.out.println(helloWordB.getMessage());
    }

}
