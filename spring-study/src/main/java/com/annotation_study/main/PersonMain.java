package com.annotation_study.main;

import com.annotation_study.config.MainPersonConfig;
import com.annotation_study.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class PersonMain {


    public static void main(String[] args) {


        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainPersonConfig.class);

        Person beanName = (Person) annotationConfigApplicationContext.getBean("person");


        String[] beanNamesForType = annotationConfigApplicationContext.getBeanDefinitionNames();

        System.out.println(beanName);

        for (String s : beanNamesForType) {
            System.out.println("beanNamesForType:" + s);
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
