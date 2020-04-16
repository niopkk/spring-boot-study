package com.bbz.ioc.step02.factory;

import com.bbz.ioc.step02.BeanDefinition;

public interface BeanFactory {


    Object getBean(String beanName);

    void registerBeanDefinition(String bean, BeanDefinition definition);

}
