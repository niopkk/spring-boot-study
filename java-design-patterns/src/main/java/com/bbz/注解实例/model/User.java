package com.bbz.注解实例.model;

import com.bbz.注解实例.Init;

public class User {


    @Init("tao")
    private String name;


    @Init("900000")
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
