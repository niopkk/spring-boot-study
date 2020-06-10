package com.bbz.spring.test;

import com.bbz.spring.controller.HelloController;
import com.bbz.spring.formework.context.ApplicationContext;

public class TestMain {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ApplicationContext("application.properties");


        HelloController helloController = (HelloController) context.getBean("helloController");

        System.out.println(helloController.say());
    }
}
