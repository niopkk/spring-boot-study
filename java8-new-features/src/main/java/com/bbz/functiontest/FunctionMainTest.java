package com.bbz.functiontest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * com.bbz.functiontest
 * <p>
 * Created by tianxin2 on 2019-07-08
 */
public class FunctionMainTest {


    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        Person p1 = new Person(1, "张三1", "2019-07-02");

        Person p2 = new Person(2, "张三2", "2019-07-02");

        Person p3 = new Person(1, "张三1", "2019-07-01");

        Person p4 = new Person(2, "张三2", "2019-07-01");

        Person p5 = new Person(3, "张三3", "2019-07-01");

        Person p6 = new Person(3, "张三3", "2019-07-02");

        Person p7 = new Person(4, "张三4", "2019-07-01");
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        persons.add(p7);


        List<Person> collect = persons.stream().filter(distinctByKey(Person::getId)).collect(Collectors.toList());


        List<Person> unique = persons.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Person::getId))), ArrayList::new)
        );

        System.out.println(unique);

        System.out.println(collect);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    static class Person implements Serializable {

        private int id;

        private String name;

        private String date;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Person(int id, String name, String date) {
            this.id = id;
            this.name = name;
            this.date = date;
        }
    }
}
