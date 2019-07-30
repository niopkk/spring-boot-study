package com.bbz.monthods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * com.bbz.monthods
 * <p>
 * Created by tianxin2 on 2019-07-29
 */
public class MainMonthodsTest {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Method add = MainMonthodsTest.class.getMethod("add", double.class, double.class);


        print(1, 3,MainMonthodsTest.class, add);

    }


    public static double add(double x, double y) {
        double z = x + y;

        System.out.println(z);
        return z;
    }

    public static void print(int x, int y,Class<?> cl, Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Object invoke = method.invoke(cl.getConstructor().newInstance() , x, y);


    }


}
