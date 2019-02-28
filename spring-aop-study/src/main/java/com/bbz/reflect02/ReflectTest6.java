package com.bbz.reflect02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectTest6 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //正常实例化
//        Book book = new Book();
//        System.out.println(book);


        Map<String, Object> classMap = new ConcurrentHashMap<>();
        classMap.put("Book", Book.class);
//
//        Class<?> c = Class.forName("reflect02.Book");
//
////        System.out.println(book);
//        Object o = c.newInstance();
//        Book book = (Book) o;
//        System.out.println(book);
//        classMap.forEach((k, v) -> {
//            System.out.println(c);
//
//        });


        //反射实例化
//        Class<?> c = Class.forName("reflect02.Book");
//        Object o = c.newInstance();
//        Book book = (Book) o;
//        System.out.println(book);


        System.out.println(11000 - 1312);

    }


}
