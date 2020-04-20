package com.bbz.ioc.step06;

public class BeanRefernce {

    public BeanRefernce(String name) {
        this.name = name;
    }

    private String name;

//    private Object bean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Object getBean() {
//        return bean;
//    }
//
//    public void setBean(Object bean) {
//        this.bean = bean;
//    }
}
