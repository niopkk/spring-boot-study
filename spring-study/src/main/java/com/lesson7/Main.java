package com.lesson7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        /**
         * 基于构造方法注入
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson7.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();

    }
}
