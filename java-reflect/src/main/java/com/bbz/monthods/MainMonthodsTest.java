package com.bbz.monthods;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * com.bbz.monthods
 * <p>
 * Created by tianxin2 on 2019-07-29
 */
public class MainMonthodsTest {



    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {


//        Method add = MainMonthodsTest.class.getMethod("add", double.class, double.class);
//
//
//        print(1, 3, MainMonthodsTest.class, add);


//        Class c = MainMonthodsTest.class;
//        c.getMethod("print", int.class, int.class, Class.class, Method.class);

        Class<?> cls = Integer.class;


        StringBuilder sb = StringBuilder.class.getConstructor(new Class[]{int.class}).newInstance(100);

        int dd = 22;
        final Integer integer = toType(dd, Integer.class);
        System.out.println("case......" + integer);

        System.out.println(sb.toString());
        final Method method = cls.getMethod("parseInt", String.class);
        final Method[] methods = cls.getMethods();
        for (Method s : methods) {
            System.out.println(s);
        }


        final Object invoke = method.invoke(null, "123");
        System.out.println(invoke);


        System.out.println(formName("int"));


    }

    private static <T> T toType(Object o, Class<T> cls) {
        return cls.cast(o);
    }

    private static Class<?> formName(String className) throws ClassNotFoundException {
        if ("int".equals(className)) {
            return int.class;
        }
        return Class.forName(className);
    }


    public static double add(double x, double y) {
        double z = x + y;

        System.out.println(z);
        return z;
    }

    public static void print(int x, int y, Class<?> cl, Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Object invoke = method.invoke(cl.getConstructor().newInstance(), x, y);


    }


}
