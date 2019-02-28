package com.springBeanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory=new XmlBeanFactory(new ClassPathResource("springbeanfactory.xml"));

        HelloWord helloWord=(HelloWord) xmlBeanFactory.getBean("helloword");
        System.out.println(helloWord.getMessage());
    }
}
