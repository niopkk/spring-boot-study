package com.xml_study.lesson1;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {



        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lesson1.xml");
        HelloWord helloWord = (HelloWord) applicationContext.getBean("helloWord");
        System.out.println(helloWord.getMessage());
    }
}
