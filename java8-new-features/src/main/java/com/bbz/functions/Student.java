package com.bbz.functions;

/**
 * com.bbz.consumers
 * <p>
 * Created by tianxin2 on 2019/12/23
 */
public class Student {

    String name;

    double socre;

    public Student(String name, double socre) {
        this.name = name;
        this.socre = socre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSocre() {
        return socre;
    }

    public void setSocre(double socre) {
        this.socre = socre;
    }
}
