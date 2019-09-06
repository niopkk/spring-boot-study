package com.annotation_study.main;

import com.annotation_study.config.MainPersonConfig;
import com.annotation_study.pojo.IStudent;
import com.annotation_study.pojo.Person;
import com.annotation_study.pojo.Red;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class PersonMain {


    public static void main(String[] args) {


        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainPersonConfig.class);

        Person beanName = (Person) annotationConfigApplicationContext.getBean("person");

        Red red = (Red) annotationConfigApplicationContext.getBean("com.annotation_study.pojo.Red");

        red.print();

        IStudent iStudent = (IStudent) annotationConfigApplicationContext.getBean("student");

        iStudent.print();

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();

        System.out.println(".person.." + beanName);

        for (String s : beanDefinitionNames) {
            System.out.println("beanDefinitionName:" + s);
        }
        int[] ints = {1, 42, 3, 2, 89, 4, 34};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }


    private static void sort(int... array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
