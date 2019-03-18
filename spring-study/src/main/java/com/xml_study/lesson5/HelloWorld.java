package com.xml_study.lesson5;

public class HelloWorld {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void init() {
        System.out.println("Bean 初始化......");
    }

    private void destory() {
        System.out.println("Bean 销毁........");
    }
}
