package com.bbz.ioc.step01;

public class BeanDefinition {

    public Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
