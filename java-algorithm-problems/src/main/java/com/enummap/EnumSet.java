package com.enummap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.enummap
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class EnumSet {

    public static void main(String[] args) {
        Set<Day> weekend = java.util.EnumSet.noneOf(Day.class);
        System.out.println(weekend);
        weekend.add(Day.MONDAY);
        weekend.add(Day.THURSDAY);

        System.out.println(weekend);

        System.out.println(java.util.EnumSet.allOf(Day.class));
        System.out.println(java.util.EnumSet.range(Day.MONDAY, Day.THURSDAY));
        System.out.println(java.util.EnumSet.of(Day.MONDAY, new Day[]{Day.THURSDAY, Day.SUNDAY}));


        Worker[] workers = new Worker[]{
                new Worker("张三", java.util.EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)),
                new Worker("李四", java.util.EnumSet.of(Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
                new Worker("王五", java.util.EnumSet.of(Day.TUESDAY, Day.THURSDAY))
        };

        Set<Day> days = java.util.EnumSet.allOf(Day.class);
        System.out.println("days前" + days);
        //那一天一个值班的人都没有
        for (Worker w : workers) {
            days.removeAll(w.getAvailableDays());
            System.out.println("days后" + days);
        }
        System.out.println("days...后" + days);


        //那一天至少有一个人来
        Set<Day> days_01 = java.util.EnumSet.noneOf(Day.class);
        System.out.println("days_01前" + days_01);
        for (Worker worker : workers) {
            days_01.addAll(worker.getAvailableDays());
        }
        System.out.println("days_01后" + days_01);

        //那一天所有人都会来
        Set<Day> days_02 = java.util.EnumSet.allOf(Day.class);
        for (Worker worker : workers) {
            days_02.retainAll(worker.getAvailableDays());
        }
        System.out.println(days_02);


        //哪些只有周一,周二会来
        Set<Worker> availableDays = new HashSet<>();
        for (Worker w : workers) {
            if (w.getAvailableDays().containsAll(java.util.EnumSet.of(Day.MONDAY, Day.TUESDAY))) {
                availableDays.add(w);
            }
        }
        for (Worker w : availableDays) {
            System.out.println("days.周一,周二.." + w.getName());
        }
    }
}
