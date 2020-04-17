package com.bbz.ioc.step01;

import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test01() {


        //实例化BeanFactory 工厂
        BeanFactory beanFactory = new BeanFactory();


        //将自定义的bean 放入到BeanDefinition类中
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWordService());

        //注入到容器当中
        beanFactory.registerBeanDefinition("helloWordService", beanDefinition);

        //ioc容器中获取bean实例
        HelloWordService helloWordService = (HelloWordService) beanFactory.getBean("helloWordService");

        //调用方法
        helloWordService.hello();
    }

}
