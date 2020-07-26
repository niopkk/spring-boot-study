package com.conditional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ConditionalConfigTest {

    @Test
    public void TestConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
