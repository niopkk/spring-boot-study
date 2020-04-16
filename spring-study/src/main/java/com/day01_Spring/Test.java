package com.day01_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {



        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Person person = (Person) applicationContext.getBean("person");

        System.out.println(person);

        Person person1 = (Person) applicationContext.getBean("person_01");

        System.out.println(person1);

        Person person2 = (Person) applicationContext.getBean("person_02");

        System.out.println(person2);
    }
}
