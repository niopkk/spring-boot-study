package com.bbz.单例模式.懒汉式;

/**
 * com.bbz.单例模式.懒汉式
 * <p>
 */
public class Singleton {

    //以下实现中，私有静态变量会被延迟实例化，这样的好处是没有用到该类就不会实例化 instance，节约资源，
    // 多线程下是不安全的，如果多个线程同时进入 if (instance == null),并且instance为null，将导致实例化多次Singleton;
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //双唇检查锁模式,存在锁和浪费内存的问题
    public static Singleton getInstanceLock() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 屏蔽锁和内存浪费的问题
     *
     * @return
     */
    public static Singleton getInstanceLazy() {
        return LazyHolder.LAZY;
    }

    public static class LazyHolder {
        private static final Singleton LAZY = new Singleton();
    }
}
