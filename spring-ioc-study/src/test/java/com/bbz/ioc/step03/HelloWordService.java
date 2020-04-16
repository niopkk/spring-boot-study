package com.bbz.ioc.step03;

public class HelloWordService {


    private String text;

    private Integer age;

    public void helloWorld(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
