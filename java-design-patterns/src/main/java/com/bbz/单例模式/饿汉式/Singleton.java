package com.bbz.单例模式.饿汉式;

/**
 * com.bbz.单例模式.饿汉式
 * <p>
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    public Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public String get(String url) {

        return " hello   " + url;
    }
}
