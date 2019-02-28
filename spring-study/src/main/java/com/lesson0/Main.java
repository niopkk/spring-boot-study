package com.lesson0;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson0.xml");


        Student student = (Student) context.getBean("student");

        student.setAge(1212);
        student.setName("sdfsdf");
        student.setSocre(78);
        System.out.println(student.getName());
        String[] strings = new String[]{"xxxxxx,第三得分点"};

        for (String s : strings) {
            System.out.println(s);
        }

//        System.out.println(6389 + 488 + 1199+299);


        System.out.println((9212 - 9052) * 1.3);

    }


}
