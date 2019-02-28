package com.lesson0;

public class Student {

    private String name;

    private Integer age;

    private Integer socre;


    public String getName() {
        return name;
    }

    public Class<?> getStudentClass(){
        return Student.class;
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

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }
}
