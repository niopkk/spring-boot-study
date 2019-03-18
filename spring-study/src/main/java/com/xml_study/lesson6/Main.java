package com.xml_study.lesson6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("lesson6.xml");
        HelloWord helloWord=(HelloWord) context.getBean("helloword");

        System.out.println(helloWord.getName());

        HelloWord1 helloWord1=(HelloWord1) context.getBean("helloword1");

        System.out.println(helloWord1.getName());

        HelloWord2 helloWord2=(HelloWord2) context.getBean("helloword2");

        System.out.println(helloWord2.getName());

    }
}
