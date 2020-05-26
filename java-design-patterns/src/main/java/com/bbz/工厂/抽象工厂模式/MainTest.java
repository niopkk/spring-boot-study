package com.bbz.工厂.抽象工厂模式;

public class MainTest {

    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        INote note = factory.createNote();
        note.edit();
        IVideo video = factory.createVideo();
        video.record();


        factory = new PythonCourseFactory();
        INote note1 = factory.createNote();
        note1.edit();
        IVideo video1 = factory.createVideo();
        video1.record();

    }
}
