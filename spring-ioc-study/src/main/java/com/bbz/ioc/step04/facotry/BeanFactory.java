package com.bbz.ioc.step04.facotry;

import com.bbz.ioc.step04.BeanDefinition;

public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param name
     * @return
     */
    Object getBean(String name);


    /**
     * 注册bean
     *
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
