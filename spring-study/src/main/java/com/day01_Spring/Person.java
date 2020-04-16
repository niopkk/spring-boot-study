package com.day01_Spring;

import java.util.List;

public class Person {

    private Integer id;

    private String name;

    private Double socre;

    private List<String> teacher;

    private List<Teacher> sList;

    public List<Teacher> getsList() {
        return sList;
    }

    public void setsList(List<Teacher> sList) {
        this.sList = sList;
    }

    public List<String> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<String> teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSocre() {
        return socre;
    }

    public void setSocre(Double socre) {
        this.socre = socre;
    }

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Double socre, String name) {
        this.name = name;
        this.socre = socre;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", socre=" + socre +
                ", teacher=" + teacher +
                ", sList=" + sList +
                '}';
    }
}
