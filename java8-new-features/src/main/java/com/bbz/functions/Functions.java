package com.bbz.functions;

import com.bbz.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * com.bbz.functions
 * <p>
 * Created by tianxin2 on 2019/12/23
 */
public class Functions {


    public static void main(String[] args) {


        List<Student> students = Lists.of(
                new Student("张三", 33d)
                , new Student("李四", 332d)
                , new Student("王五", 32));


//        students = filter(students, student -> student.getName().equals("张三"));

//        students.forEach(student -> System.out.println(student.getName()));

//        List<String> strings = map(students, t -> t.getName());
//        for (String s : strings) {
//            System.out.println(s);
//        }
        foreach(students, student -> System.out.println(student.getName()));

        final List<String> of = Lists.of(new String[]{"1"});

        final String[] strings = of.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

    }


    private static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> reList = new ArrayList<>();
        for (T t : list) {
            reList.add(mapper.apply(t));
        }
        return reList;
    }

    private static <E> List<E> filter(List<E> list, Predicate<E> predicate) {
        List<E> reList = new ArrayList<>();
        for (E e : list) {
            if (predicate.test(e)) {
                reList.add(e);
            }
        }
        return reList;
    }

}
