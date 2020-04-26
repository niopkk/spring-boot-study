package com.bbz.serviced;


import com.bbz.model.Student;

public interface MessageService {

    String say();

    String say(String name);


    Student findById(String id);
}
