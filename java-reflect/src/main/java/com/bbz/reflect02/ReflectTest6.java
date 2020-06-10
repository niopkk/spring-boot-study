package com.bbz.reflect02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectTest6 {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //正常实例化
//        Book book = new Book();
//        System.out.println(book);


//        Map<String, Object> classMap = new ConcurrentHashMap<>();
//        classMap.put("Book", Book.class);
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
//        Constructor<?> declaredConstructor = c.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        Object o1 = declaredConstructor.newInstance();
//        Book book = (Book) o1;
//        book.setName("数");
//        System.out.println(book);
        System.out.println(c.getName());
//        System.out.println(c.getSimpleName());
        Field[] fields = c.getDeclaredFields();
        Object instance = c.newInstance();
        for (Field field : fields) {
            System.out.println("dsdfdf;"+field.getType().getName());
            System.out.println("dfdfdsfdsasdasd;"+field.getType().getSimpleName());

            field.setAccessible(true);
            field.set(instance, "list");
        }
        Book book = (Book) instance;
        System.out.println(book.getName());


    }


}
