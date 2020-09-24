package com.beanFactoryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {


    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Config.class);


//        Welcomer bean = annotationConfigApplicationContext.getBean(Welcomer.class);

//        System.out.println(bean.getWelcomeText());

//        final Person bean = annotationConfigApplicationContext.getBean(Person.class);
//        System.out.println(bean);

    }
}
