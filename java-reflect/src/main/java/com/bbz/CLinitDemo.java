package com.bbz;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/12/20
 */
public class CLinitDemo {

    public static class Hello {
        static {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {

        final ClassLoader cl = ClassLoader.getSystemClassLoader();
        final String className = CLinitDemo.class.getName() + "$Hello";
        try {
            final Class<?> cls = cl.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
