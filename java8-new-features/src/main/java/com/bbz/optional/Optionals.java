package com.bbz.optional;

import com.bbz.util.Dates;
import com.bbz.util.Lists;
import com.bbz.util.Strings;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * com.bbz.optional
 * <p>
 * Created by tianxin2 on 2019-09-09
 */
public class Optionals {


    public static void main(String[] args) {


        String s = "";

        String s1 = Optional.ofNullable(s).filter(l -> Strings.isNoneBlank(l)).map(v -> "123").orElse("d");

        String s2 = Optional.of(s).orElse("null");

//        System.out.println("..." + s2);


        Boolean b = null;

        String sdf = Optional.ofNullable(b).map(v -> "是").orElse("否");

        List<Student> stringLists = new ArrayList<>();
        stringLists.stream().map(item -> {
            item.setId("21343");
            return item;
        }).collect(Collectors.toList());

        stringLists.forEach(item -> {
            System.out.println(item.getId());
        });

        trans<String, Integer, Integer> trans = (s3, integer) -> {

            System.out.println("......" + 4);
            return 4;
        };


//
//        System.out.println(s1);
//
//
//        System.out.println(sdf);


        Date date = new Date();

        Date date1 = date;

        date = Dates.addDays(new Date(), 1);

        System.out.println(date);
        System.out.println(date1);

    }

    interface trans<I, O, C> {
        O tr(I i, C c);

    }


    private void testList(List list) {
        Student student = new Student();
        student.setId("1232");
        list.add(student);
    }

    static class Student {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
