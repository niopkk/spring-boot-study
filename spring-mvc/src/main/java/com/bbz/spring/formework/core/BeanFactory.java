package com.bbz.spring.formework.core;

public interface BeanFactory {

    /**
     * 获取根据beanName 获取bean对象
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    Object getBean(String beanName) throws Exception;


    /**
     * 根据类型获取bean对象
     *
     * @param beanClass
     * @return
     * @throws Exception
     */
    Object getBean(Class<?> beanClass) throws Exception;
}
