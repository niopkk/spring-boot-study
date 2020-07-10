package com.bbz.classindex;

import com.bbz.util.Jsons;
import org.atteo.classindex.ClassIndex;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassIndexMain {


    public static void main(Class<?> target) throws IllegalAccessException, InstantiationException {
//        List<Class<?>> sources = (List) Stream.of(ClassIndex.getAnnotated(Application.class)).collect(Collectors.toList());

//        sources.add(0, target);
//        sources.add(0, Teacher.class);

//        for (Class<?> classzz:sources) {
//
//            String typeName = classzz.getTypeName();
//
//            System.out.println();
//        }
        Iterable<Class<?>> annotated = ClassIndex.getAnnotated(Application.class);
        //            System.out.println(aClass.getTypeName())
        for (Class<?> aClass : annotated) {

            Teacher type = getType(Teacher.class, aClass.newInstance());
            type.setAge(223);
            type.setName("323");

            System.out.println(Jsons.toJson(type));
        }
//        System.out.println(sources);
    }

    private static  <T> T getType(Class<T> classzz, Object object) {
        return classzz.cast(object);
    }
}
