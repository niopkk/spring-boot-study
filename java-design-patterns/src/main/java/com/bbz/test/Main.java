package com.bbz.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * com.bbz.test
 * <p>
 * Created by tianxin2 on 2019-07-01
 */
public class Main {

    public static void main(String[] args) {
//        Student student = new Student();
//
//
//        System.out.println(student.hashCode());
//
//        student.setAge(12);
//        student.setName("掌声");
//
//        System.out.println(student.hashCode());
//
//        Student student1 = new Student();
//        System.out.println(student1.hashCode());

        String FIELD_SEPARATOR = Character.toString((char) 0x01);

        System.out.println(FIELD_SEPARATOR);

        System.out.println(get1());

        System.out.println(get2());

    }

    private static Integer get1() {
        Student student = new Student();
        return student.hashCode();
    }

    private static Integer get2() {
        Student student = new Student();
        return student.hashCode();
    }
}
