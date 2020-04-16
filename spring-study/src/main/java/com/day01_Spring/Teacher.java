package com.day01_Spring;

import java.util.List;

public class Teacher {

    private Integer id;

    private String name;

    private List<Teacher> sList;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sList=" + sList +
                '}';
    }

    public List<Teacher> getsList() {
        return sList;
    }

    public void setsList(List<Teacher> sList) {
        this.sList = sList;
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

}
