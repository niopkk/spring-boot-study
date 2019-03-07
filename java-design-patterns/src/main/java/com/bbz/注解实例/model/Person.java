package com.bbz.注解实例.model;

import com.bbz.注解实例.Init;

@Init(value = "csss",name = "person")
public class Person {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
