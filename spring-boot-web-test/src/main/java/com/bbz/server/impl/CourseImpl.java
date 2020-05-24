package com.bbz.server.impl;

import com.bbz.model.JavaCourse;
import com.bbz.repository.ICourseRepository;
import com.bbz.server.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements ICourse {

    @Autowired
    private ICourseRepository courseRepository;


    @Override
    public List<JavaCourse> findCourseAll() {
        List<JavaCourse> courseAll = courseRepository.findCourseAll();
//        List<JavaCourse> courses = courseAll.stream().map(course -> new JavaDiscountCourse(course.getId(), course.getCourseName(), course.getPrice()))
//                .collect(Collectors.toList());
        return courseAll;
    }
}
