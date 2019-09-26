package com.bbz.enumtest;

/**
 * com.bbz.enumtest
 * <p>
 * Created by tianxin2 on 2019-09-16
 */
public class MainTest {

    public static void main(String[] args) {



        Student student=new Student();

        student.setAccountType(Student.AccountType.valueOf("ADDED"));

        System.out.println(student);
    }
}
