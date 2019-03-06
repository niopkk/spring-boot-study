package com.bbz.ioc.bean;

public interface BeanDefinitionRegistery {
    void register(BeanDefinition bd, String beanName);

    BeanDefinition getBeanDefinition(String beanName);


    Boolean containsBeanDefinition(String beanName);
}
