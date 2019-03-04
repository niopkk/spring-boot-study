package com.bbz.注解实例;


import com.bbz.注解实例.model.User;

public class UserMain {


    public static void main(String[] args) {


        User user = UserFactory.createUser();


        System.out.println(user.getAge());
        System.out.println(user.getName());



//        System.out.println(AutowiredAnnotationBeanPostProcessor.class.getClassLoader().getParent());

    }
}
