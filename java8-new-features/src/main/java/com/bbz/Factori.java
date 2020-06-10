package com.bbz;

import com.bbz.util.Strings;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/11/27
 */
public class Factori {

    public static void main(String[] args) {
//        System.out.println(new Factori().fact.apply(5));


//        int j = i++;
//        System.out.println(i);
//        System.out.println(j);

//        List<Student> list = new ArrayList<>();
//
//        list.add(new Student("111", 2222));
//        list.add(new Student("222", 1111));
//        list.stream().peek(p -> p.setName(p.getName().replace("111", "*"))).collect(Collectors.toList()).forEach(a -> {
//            System.out.println(a.getName());
//        });
//        String s="1111|2222";
//        String[] split = s.split("\\|");
//        System.out.println(split);


        String s = "my.test.txt";
        System.out.println(s.replace(".", "#"));
        System.out.println(s.replaceAll("\\.", "#"));
        System.out.println(s.replaceFirst("\\.", "#"));

        String className="Test";
        System.out.println(Strings.uncapitalize(className));


//        List<String> collect = Stream.of("0123456789").peek(p -> p.replace("1", "*"))
//                .collect(Collectors.toList());
//


//        Factori factori=new Factori();
//        System.out.println(factori.toString());
////
//        String ss="ddddddd";
//        System.out.println(ss.replace("'",""));

//        String d="ew";dfsd
//        if(!"0".equals(d)){
//
////dsd
////            dfs
//            System.out.println("dsddfsdf");
//        }else {
//            System.out.println("3333");
//        }

    }

    static class Student {

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    private static void sum(int index) {
        System.out.println("index:" + index);
    }

    //24-32
//    private UnaryOperator<Integer> fact = x -> ((x == 1 || x == 0) ? 1 : x * this.fact.apply(x - 1));
}
