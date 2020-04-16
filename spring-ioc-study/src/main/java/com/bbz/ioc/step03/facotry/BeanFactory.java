package com.bbz.ioc.step03.facotry;

import com.bbz.ioc.step03.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(Class<T> tClass);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;
}
