package com.bbz.注解实例;


import com.bbz.注解实例.model.Person;
import com.bbz.注解实例.model.User;

public class UserMain {


    public static void main(String[] args) {


        UserFactory.createUser(User.class);
        UserFactory.createUser(Person.class);


//        System.out.println(AutowiredAnnotationBeanPostProcessor.class.getClassLoader().getParent());

    }
}
