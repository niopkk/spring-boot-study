package com.bbz.ioc.step01;

import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test01() {

        BeanFactory beanFactory = new BeanFactory();


        BeanDefinition beanDefinition = new BeanDefinition(new HelloWordService());

        beanFactory.registerBeanDefinition("helloWordService", beanDefinition);

        HelloWordService helloWordService = (HelloWordService) beanFactory.getBean("helloWordService");

        helloWordService.hello();
    }

}
