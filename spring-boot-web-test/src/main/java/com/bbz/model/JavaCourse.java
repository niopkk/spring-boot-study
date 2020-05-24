package com.bbz.model;

import com.bbz.support.ICourse;

public class JavaCourse implements ICourse {


    private Integer id;

    private String courseName;

    private Double price;



    public JavaCourse(Integer id, String courseName, Double price) {
        this.id = id;
        this.courseName = courseName;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }

    @Override
    public Double getPrice() {
        return this.price;

    }
}
