package com.bbz.annotation04.定制序列化;

import java.util.Date;

/**
 * com.bbz.annotation04
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class Student {

    @AnnotationTest.Lable("姓名")
    private String name;

    @AnnotationTest.Lable("出生日期")
    @AnnotationTest.Format(pattern = "yyyy/MM/dd")
    private Date born;

    @AnnotationTest.Lable("分数")
    private double score;

    public Student(String name, Date born, double score) {
        this.name = name;
        this.born = born;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
