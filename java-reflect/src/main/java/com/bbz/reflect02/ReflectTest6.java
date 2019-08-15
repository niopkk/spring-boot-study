package com.bbz.reflect02;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectTest6 {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
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
        Class<?> c = Class.forName("com.bbz.reflect02.Book");
        Object o = c.getDeclaredConstructor().newInstance();
        Book book = (Book) o;
        book.setName("数");
        System.out.println(book);


    }


}
