package com.day_02_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {


//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aop.xml");
//        MithI mithImpl = applicationContext.getBean("mithImpl", MithI.class);
//        System.out.println(mithImpl.add(1,1));

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        MithI mithImpl = applicationContext.getBean("mithImpl", MithI.class);
        mithImpl.div(33, 1);

//        mithImpl.miu(10, 0);
//        mithImpl.div(10, 0);

    }
}
