package com.bbz.consumer.形参实数;

import java.lang.reflect.Field;

/**
 * com.bbz.ConsumerTest.形参实数
 * <p>
 * Created by tianxin2 on 2019-05-05
 */
public class TestMain {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Integer var1 = 3;
        Integer var2 = 4;


        System.out.printf("%s.....%s\n", var1, var2);

        swap(var1, var2);

        System.out.printf("%s.....%s\n", var1, var2);

        swap1(var1, var2);

        System.out.printf("%s.....%s\n", var1, var2);

        int var3 = 9;
        int var4 = 10;
        swap3(var3,var4);
        System.out.printf("%s.....%s\n", var3, var4);

    }

        private static void swap3(int var3, int var4) {
        int temp = var3;
        var3 = var4;
        var4 = temp;
    }

    private static void swap(Integer var1, Integer var2) {
        Integer temp = var1;
        var1 = var2;
        var2 = temp;
    }

    private static void swap1(Integer var1, Integer var2) throws NoSuchFieldException, IllegalAccessException {
        int temp = var1.intValue();
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(var1, var2);
        field.set(var2, new Integer(temp));
    }
}
