package com.bbz.model;

public class JavaDiscountCourse extends JavaCourse {


    public JavaDiscountCourse(Integer id, String courseName, Double price) {
        super(id, courseName, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.61;
    }
}
