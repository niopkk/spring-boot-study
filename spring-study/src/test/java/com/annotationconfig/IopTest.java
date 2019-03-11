package com.annotationconfig;

import com.annotationconfig.config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IopTest {


    @Test
    public void TestConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
