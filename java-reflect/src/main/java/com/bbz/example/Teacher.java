package com.bbz.example;

/**
 * com.bbz.example
 * <p>
 * Created by tianxin2 on 2019-09-26
 */
public class Teacher {


    public void getName(String name) {

        System.out.println(name + "非static");
    }

    public static void getSubject(String subject) {
        System.out.println(subject + ".....static");
    }


}
