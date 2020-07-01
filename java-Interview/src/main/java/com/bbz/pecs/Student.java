package com.bbz.pecs;

public class Student extends Teacher {


    public Student(String name, String subject, String age, String gender) {
        super(name, subject);
        this.age = age;
        this.gender = gender;
    }

    private String age;

    private String gender;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
