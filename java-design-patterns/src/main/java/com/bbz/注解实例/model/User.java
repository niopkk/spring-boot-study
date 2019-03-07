package com.bbz.注解实例.model;

import com.bbz.注解实例.Init;

@Init(value = "tao",name = "李四")
public class User {


    private String name;


    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
