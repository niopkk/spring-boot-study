package com.bbz.map;

import com.bbz.util.Lists;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


        System.out.println(map);

        List<Student> lists = new LinkedList<>();

        Student student = new MainMap().new Student();
        Student student2 = new MainMap().new Student();

        student.setRegions(Lists.of("11111", "2222"));
        student2.setRegions(Lists.of("11111", "2222"));


        lists.add(student);
        lists.add(student2);

        final Set<String> collect = lists.stream().flatMap(item -> {
            return item.getRegions().stream().map(String::intern);
        }).collect(Collectors.toSet());

        System.out.print(collect);


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
//        map1.put("key", 11);
//        map1.put("key2", 11);
//        map1.put("key3", 11);
//        map1.put("key4", 11);


        final int sum = Optional.ofNullable(map1).map(Map::values).get().stream().mapToInt(Integer::intValue).sum();

        System.out.println(",,,,," + sum);
    }


    public class Student {
        private String name;

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
    }
}
