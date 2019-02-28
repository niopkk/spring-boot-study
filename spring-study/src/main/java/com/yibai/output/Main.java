package com.yibai.output;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        方案一
//        IOutputGenerator outputGenerator=new CsvOutputGenerator();
//        outputGenerator.generateOutput();

//        方案三
//        OutputHelper outputHelper = new OutputHelper();
//        outputHelper.generateOutput();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/yibai/spring-common.xml");

        OutputHelper outputHelper = (OutputHelper) applicationContext.getBean("outputHelper");

        outputHelper.generateOutput();


    }
}
