package com.bbz.工厂.非标准;

public class Main {

    public static void main(String[] args) {


        Factory factory = new StudentFactory();

        Student student = factory.getStudent();
        System.out.println(student);
    }
}
