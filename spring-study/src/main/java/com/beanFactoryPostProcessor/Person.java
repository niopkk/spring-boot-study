package com.beanFactoryPostProcessor;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class Person implements InitializingBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("初始化对象构造函数.............");
    }

    @PostConstruct
    public void postInit() {
        System.out.println("post init 方法执行..............");
        System.out.println("post init 方法执行.............." + toString());
    }

    public void init() {
        System.out.println("init 方法执行..........");
        System.out.println("init 方法执行.........." + toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...............");
        System.out.println("afterPropertiesSet..............." + toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

