package com.xml_study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


    public static void main(String[] args) {


        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = (Car) cxt.getBean("car");
        System.out.println(car.toString());

         car = (Car) cxt.getBean("car1");
        System.out.println(car.toString());
        Person person = cxt.getBean(Person.class);

        System.out.println(person.toString());
    }
}
