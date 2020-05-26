package com.bbz.工厂.抽象工厂模式;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public IVideo createVideo() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }
}
