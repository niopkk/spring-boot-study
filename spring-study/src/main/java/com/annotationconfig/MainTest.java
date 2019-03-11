package com.annotationconfig;

import com.annotationconfig.config.Config;
import com.annotationconfig.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {


    public static void main(String[] args) {
//       new  ClassPathXmlApplicationContext("s")
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Config.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

    }
}
