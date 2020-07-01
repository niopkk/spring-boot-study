package com.bbz.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Lists {


    static <T> List<T> of(T... value) {
        return value != null ? Stream.of(value).collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }

    static <T> List<T> of(Iterable<T> iterable) {
        return (List) Stream.of(iterable).collect(Collectors.toList());
    }



//    //使用TreeSet去重
//    List<Book> unique1 = books.stream().collect(
//            collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))),
//                    ArrayList::new));
//
//        System.out.println(unique1);
//
//    //使用map去重
//    List<Book> unique2 = books.stream()
//            .filter(distinctByKey(o -> o.getId()))
//            .collect(Collectors.toList());
//        System.out.println(unique2);
//
//
//    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
//        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
//        System.out.println("这个函数将应用到每一个item");
//        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
//    }

}
