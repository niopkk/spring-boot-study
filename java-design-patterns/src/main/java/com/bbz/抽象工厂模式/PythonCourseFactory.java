package com.bbz.抽象工厂模式;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public IVideo createVideo() {
        return new PythonCourse();
    }

    @Override
    public INote createNote() {
        return new PythonNote();
    }
}
