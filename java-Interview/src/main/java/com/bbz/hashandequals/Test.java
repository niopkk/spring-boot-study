package com.bbz.hashandequals;

public class Test {

    public static void main(String[] args) {
        Student student=new Student("zhang",21);
        System.out.println(student.hashCode());

        Student student1=new Student("zhang",21);
        System.out.println(student1.hashCode());
        System.out.println(student==student1);

        System.out.println(student.equals(student1));

        Student student2=new Student();
        Student student3=new Student();

        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());
        System.out.println(student3.equals(student2));
    }
}
