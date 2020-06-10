package com.bbz.hashandequals;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
//        Student student = new Student("zhang", 21);
//        System.out.println(student.hashCode());
//
//        Student student1 = new Student("zhang", 21);
//        System.out.println(student1.hashCode());
//        System.out.println(student == student1);
//
//        System.out.println(student.equals(student1));
//
//        Student student2 = new Student();
//        Student student3 = new Student();
//
//        System.out.println(student2.hashCode());
//        System.out.println(student3.hashCode());
//        System.out.println(student3.equals(student2));


        Map<String, Set<String>> setMap = new ConcurrentHashMap<>();
        Set<String> sets = new LinkedHashSet<>();
        sets.add("111");
        setMap.put("dddd", sets);
        sets.add("2222");
        setMap.put("dddd", sets);
        setMap.forEach((k, v) -> {
            System.out.println("key:" + k);
            v.stream().forEach(s -> {
                System.out.println("values:" + s);
            });
        });
    }

}
