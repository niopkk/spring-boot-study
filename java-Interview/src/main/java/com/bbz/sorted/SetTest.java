package com.bbz.sorted;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {


        SortedSet<Long> sortedSet = new TreeSet<>();



        sortedSet.add(1L);
        sortedSet.add(5L);
        sortedSet.add(3L);
        sortedSet.add(4L);


        sortedSet.forEach(s -> System.out.println(s));

        sortedSet.headSet(3L).clear();

        System.out.println("..........................");
        sortedSet.forEach(s -> System.out.println(s));

        System.out.println("..........................");
        sortedSet.remove(4L);
        sortedSet.forEach(s -> System.out.println(s));
    }
}
