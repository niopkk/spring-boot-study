package com.annotationstudy.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String bean : beanNames) {
            System.out.println(bean);
        }

    }
}
