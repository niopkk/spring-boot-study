package com.bbz.functiontest;

import java.util.ArrayList;
import java.util.List;

/**
 * com.bbz.functiontest
 * <p>
 * Created by tianxin2 on 2019-07-10
 */
public class StudentMainTest {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();
        list.add("001");
        list.add("002");
        Student s = new Student("Tom", list);

        System.out.println("Tom's course.length = " + s.getCourses().size());

        ArrayList<String> anotherList = s.getCourses();

        anotherList.add("999");

        System.out.println("Tom's course.length = " + s.getCourses().size());


        ArrayList<String> list1 = new ArrayList<>();
        list1.add("001");
        list1.add("002");
        Student1 s1 = new Student1("Tom", list1);


        s1.addCourse("9999");

        s1.removeCourse("001");
        List<String> anotherList1 = s1.getCourses();

        /**
         * throws java.lang.UnsupportedOperationException
         * should replace with s.addCourse(String course)
         */
//        anotherList1.add("999");

        // never reached
        System.out.println("Tom's course.length1 = " + s1.getCourses().size());
    }
}
