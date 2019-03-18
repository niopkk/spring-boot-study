package com.xml_study.lesson9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson9.xml");

        TextEditor textEditor = (TextEditor) context.getBean("helloWord");
        textEditor.spellChecker();
    }
}
