package com.bbz.ioc.step06.beans.factory;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

//    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
