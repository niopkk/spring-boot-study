package com.bbz.repository;

import com.bbz.model.JavaCourse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ICourseRepository {

    public List<JavaCourse> findCourseAll() {
        List<JavaCourse> courses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            courses.add(new JavaCourse(i, "课程" + i, 20D));
        }

        return courses;
    }
}
