package com.ThreadLocal;

import java.util.Arrays;

public class TestMain {

    public static ThreadLocal<String> t1 = new ThreadLocal<>();

    public static void main(String[] args) {

        if (t1.get() == null) {
            System.out.println("为ThreadLocal类放入新值");
            t1.set("aaaa");
        }

        System.out.println(t1.get());

        Student[] students = new Student[]{new Student("11"), new Student("212")};

        Arrays.stream(students).forEach(student -> System.out.println(student.value));
    }

    static class Student {

        private String value;

        public Student(String value) {
            this.value = value;
        }
    }
}
