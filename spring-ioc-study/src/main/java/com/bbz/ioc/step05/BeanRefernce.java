package com.bbz.ioc.step05;


public class BeanRefernce {

    public String name;

    private Object bean;

    public BeanRefernce(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
