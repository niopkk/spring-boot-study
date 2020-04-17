package com.bbz.ioc.step03.facotry;

import com.bbz.ioc.step03.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name);


    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;
}
