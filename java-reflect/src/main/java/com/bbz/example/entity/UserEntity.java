package com.bbz.example.entity;

import com.bbz.example.annotation.Verification;


public class UserEntity {

    @Verification(validate = false)
    private String name;

    @Verification
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
