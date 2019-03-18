package com.annotation_study.main;

import com.annotation_study.config.MainPersonConfig;
import com.annotation_study.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonMain {


    public static void main(String[] args) {


        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainPersonConfig.class);

        Person beanName = (Person) annotationConfigApplicationContext.getBean("person");


        String[] beanNamesForType = annotationConfigApplicationContext.getBeanDefinitionNames();

        System.out.println(beanName);

        for (String s : beanNamesForType) {
            System.out.println("beanNamesForType:"+s);
        }
    }
}
