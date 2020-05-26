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
        if (null != LazyHolder.LAZY) {
            throw new RuntimeException("不允许创建多个实例");
        }
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
     * 每一个关键字都不多余
     * static 是为了单例的空间共享，final 保证不会被重写、重载
     * @return
     */
    public final static Singleton getInstanceLazy() {
        //返回结果前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    public static class LazyHolder {
        private static final Singleton LAZY = new Singleton();
    }
}
