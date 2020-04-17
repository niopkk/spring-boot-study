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

        //3、set全类名
        beanDefinition.setBeanClassName("com.bbz.ioc.step02.HelloWordService");

        //注入bean
        beanFactory.registerBeanDefinition("helloWordService",beanDefinition);


        //获取bean
        HelloWordService helloWordService = (HelloWordService)beanFactory.getBean("helloWordService");
        //调用方法
        helloWordService.hello();
    }

}
