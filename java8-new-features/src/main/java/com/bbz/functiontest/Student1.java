package com.bbz.functiontest;

import java.util.Collections;
import java.util.List;

/**
 * com.bbz.functiontest
 * <p>
 * Created by tianxin2 on 2019-07-10
 */
public class Student1 {

    private String name;

    private List<String> courses;

    public Student1(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    public String removeCourse(String course) {
        boolean removed = this.courses.remove(courses);

        if (removed) {
            return course;
        } else {
            return null;
        }
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}
