package com.xml_study.lesson3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lesson3.xml");

        HelloWorldService service = (HelloWorldService) applicationContext.getBean("helloWorldService");

        HelloWord helloWord= service.getHelloWord();

        helloWord.sayHello();

    }
}
