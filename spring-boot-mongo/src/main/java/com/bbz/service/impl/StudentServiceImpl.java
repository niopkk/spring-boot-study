package com.bbz.service.impl;

import com.bbz.model.Student;
import com.bbz.repository.StudentRepository;
import com.bbz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


//    @Autowired
//    private MongoOperations mongoOperations;

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student save(Student student) {

        studentRepository.save(student);
        return null;

    }
}
