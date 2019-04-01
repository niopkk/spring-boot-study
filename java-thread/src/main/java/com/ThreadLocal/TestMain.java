package com.ThreadLocal;

public class TestMain {

    public static ThreadLocal<String> t1 = new ThreadLocal<>();

    public static void main(String[] args) {

        if (t1.get() == null) {
            System.out.println("为ThreadLocal类放入新值");
            t1.set("aaaa");
        }

        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
