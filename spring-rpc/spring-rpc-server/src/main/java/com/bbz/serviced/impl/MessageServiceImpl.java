package com.bbz.serviced.impl;

import com.bbz.model.Student;
import com.bbz.serviced.MessageService;

public class MessageServiceImpl implements MessageService {
    @Override
    public String say() {
        return "dsdfsdf";
    }

    @Override
    public String say(String name) {
        return "dsfds" + name;
    }

    @Override
    public Student findById(String id) {
        Student student = new Student();
        student.setAge(1);
        student.setName("张三");
        student.setId(1);
        return student;
    }
}
