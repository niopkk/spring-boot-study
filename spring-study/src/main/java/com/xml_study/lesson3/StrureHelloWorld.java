package com.xml_study.lesson3;

public class StrureHelloWorld implements HelloWord {

    private String message;

    public void sayHello() {
        System.out.println("strue say hello world" + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
