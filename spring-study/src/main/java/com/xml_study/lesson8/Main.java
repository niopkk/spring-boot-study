package com.xml_study.lesson8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson8.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.setSpellCheck();

    }
}
