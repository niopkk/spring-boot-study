package com.bbz.classindex;

import org.atteo.classindex.ClassIndex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassIndexMain {


    public static void main(Class<?> target) {
        List<Class<?>> sources = (List) Stream.of(ClassIndex.getAnnotated(Application.class)).collect(Collectors.toList());

//        sources.add(0, target);
//        sources.add(0, Teacher.class);


        System.out.println(sources);
    }
}
