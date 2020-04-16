package com.bbz.ioc.step02;

import com.bbz.ioc.step02.factory.AutowrieCapableBeanFactory;
import com.bbz.ioc.step02.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {


    @Test
    public void test(){
        //1、初始化beanFactory
        BeanFactory beanFactory=new AutowrieCapableBeanFactory();
        //2、注入bean
        BeanDefinition beanDefinition=new BeanDefinition();

        beanDefinition.setBeanClassName("com.bbz.ioc.step02.HelloWordService");
//        beanDefinition.setBean(new HelloWordService());
        beanFactory.registerBeanDefinition("helloWordService",beanDefinition);


        //获取bean
        HelloWordService helloWordService = (HelloWordService)beanFactory.getBean("helloWordService");

        helloWordService.hello();
    }

}
