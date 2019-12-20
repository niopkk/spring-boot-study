package com.bbz;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/12/20
 */
public class ClassLoadDemo {


    public static void main(String[] args) {
//        ClassLoader cls = ClassLoadDemo.class.getClassLoader();
//        while (cls != null) {
//            System.out.println(cls.getClass().getName());
//            cls = cls.getParent();
//        }
//        System.out.println(String.class.getClassLoader());

        final ClassLoader cl = ClassLoader.getSystemClassLoader();

        try {
            final Class<?> cls = cl.loadClass("java.util.ArrayList");
            final ClassLoader classLoader = cls.getClassLoader();
            System.out.println(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
