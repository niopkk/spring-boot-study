package com.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext cxt=new ClassPathXmlApplicationContext("bean-factory.xml");

        Car car = (Car) cxt.getBean("car1");
        System.out.println(car);

//        Childer bean = cxt.getBean(Childer.class);
        Parent bean1 = cxt.getBean(Parent.class);
        bean1.say();
    }
}
