package com.bbz.pecs;

import com.bbz.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pecs {

    public static void main(String[] args) {

        List<? extends Teacher> numbers = new ArrayList<>();

        //编译报错
        //numbers.add(new Student("张三","化学","12","323"));
        //numbers.add(new Teacher("张三","化学"));

        List<Student> dd = new ArrayList<>();

        dd.add(new Student("张三1", "化学1", "123ee", "3233sdf"));
        dd.add(new Student("张三2", "化学2", "12eee", "32fds3"));
//        dd.add(new Student("张三3", "化学3", "12eee", "df323"));
        //编译报错
        //numbers.add(new Teacher("张三1", "化学1"));

//
//        if (dd.size()>1){
//            System.out.println("..............");
//        }
        String[] strArray = "array-a/array-b".split("/");
        List<String> strList = Arrays.asList(strArray);

        for (String s : strList) {
            System.out.println(s);
        }

        numbers = dd;

        for (Teacher t : numbers) {
            System.out.println(t.getName());
        }
    }
}
