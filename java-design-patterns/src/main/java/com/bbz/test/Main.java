package com.bbz.test;

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
