package com.bbz.test;

import com.bbz.util.Maps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", 2));
        personList.add(new Person("b", 4));
        personList.add(new Person("c", null));
        // 升序
        personList.stream().map(p -> {
                    p.setAge(Optional.ofNullable(p.getAge())
                            .orElse(0));
                    return p;
                }
        )
                .collect(Collectors.toList());

        personList.sort(Comparator.comparingInt(Person::getAge));
        // 降序
//        personList.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println(personList);


        Map<String, Integer> map = new HashMap<>();

        map.put("1", 1);
        map.put("3", 3);
        map.put("4", 4);
        map.put("9", 9);
        map.put("5", 5);


        System.out.println(Maps.sortByKey(map, Maps.asc()));


    }

    public static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
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
