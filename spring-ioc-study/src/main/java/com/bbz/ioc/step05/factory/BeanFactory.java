package com.bbz.ioc.step05.factory;

import com.bbz.ioc.step05.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition definition) throws Exception;
}
