package com.bbz.spring.formework.beans.config;

public class BeanPostProcessor {


    public Object postProcessorBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    public Object postProcessorAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
