package com.bbz.map;

import com.bbz.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * com.bbz.map
 * <p>
 * Created by tianxin2 on 2019-10-08
 */
public class MainMap {


    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();

        map.put("A", "1111");



        map.merge("A", "2", (oldVal, newVal) -> oldVal + newVal);
        map.merge("3", "222", (oldVal, newVal) -> oldVal);

        Map<String, Integer> map_1 = new HashMap<>();

        map_1.put("A", 1111);

        map_1.merge("A", 2, (oldVal, newVal) -> oldVal + newVal);
        map_1.merge("3", 222, (oldVal, newVal) -> oldVal);



        System.out.println(map);

        System.out.println(map_1);

        List<Student> lists = new ArrayList<>();

        Student student = new Student();
        Student student2 = new Student();

        student.setAge(111);
        student.setRegions(Lists.of("11111", "2222"));
        student2.setAge(4444);
        student2.setRegions(Lists.of("111112", "2222"));


        lists.add(student2);
        lists.add(student);

//        final Set<String> collect = lists.stream().flatMap(item -> {
//            return item.getRegions().stream().map(String::intern);
//        }).collect(Collectors.toSet());

        final List<Student> collect = lists.stream().sorted((s1, s2) -> s2.getAge().compareTo(s1.getAge())).collect(Collectors.toList());

        collect.forEach(ds -> {
            System.out.println(ds.getAge());
        });


        String sdf = "1";
        try {

//            int ds = Integer.valueOf(sdf);
//            System.out.println("正确:" + ds);
            System.exit(1);
        } finally {
            System.out.println("finally:....1111");
        }


//        LocalDate today = LocalDate.now();
//        //本月的第一天
//        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
//        //本月的最后一天
//        LocalDate lastDay =today.with(TemporalAdjusters.lastDayOfMonth());
//        System.out.println("本月的第一天"+firstday);
//        System.out.println("本月的最后一天"+lastDay);


//        List<Map> list = new LinkedList<>();
//        Map<String, Object> res = new LinkedHashMap<>();
//        res.put("name","111");
//        list.add(res);
//        Map<String, Object> res1 = new LinkedHashMap<>();
//        res1.put("name","111");
//        list.add(res1);
//        Map<String, Object> res2 = new LinkedHashMap<>();
//        res2.put("name","111");
//        list.add(res2);
//        Map<String, Object> res3 = new LinkedHashMap<>();
//        res3.put("name","");
//        list.add(res3);
//
//        List<Map> name = list.stream().filter(p -> !p.get("name").equals("")).collect(Collectors.toList());
//
//        System.out.println(name);

        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("key", 11);
        map1.put("key2", 11);
        map1.put("key3", 11);
        map1.put("key4", null);


        final Long aLong = Optional.ofNullable(map1)
                .map(item -> {
                    long sum1 = item.entrySet().stream().filter(v -> Objects.nonNull(v.getValue())).mapToLong(Map.Entry::getValue).sum();
                    return sum1;
                }).orElse(0L);

        System.out.println(",,,,," + aLong);






    }


    public static class Student {

        private String name;

        private Integer age;


        private List<String> regions;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getRegions() {
            return regions;
        }

        public void setRegions(List<String> regions) {
            this.regions = regions;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
