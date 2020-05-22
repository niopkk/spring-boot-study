package com.bbz.service.impl;

import com.bbz.model.Student;
import com.bbz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public class StudentServiceImpl implements StudentService {


    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Student save(Student student) {


        return null;

    }
}
