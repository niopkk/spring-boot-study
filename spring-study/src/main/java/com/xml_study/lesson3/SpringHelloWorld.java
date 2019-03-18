package com.xml_study.lesson3;

public class SpringHelloWorld implements HelloWord {

    private String message;

    public void sayHello() {
        System.out.println("spring say hello world" + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
