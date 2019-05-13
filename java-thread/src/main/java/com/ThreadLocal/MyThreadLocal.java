package com.ThreadLocal;

/**
 * com.ThreadLocal
 * <p>
 * Created by tianxin2 on 2019-05-13
 */
public class MyThreadLocal {


    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("hello");
        threadLocal.set("212");
        System.out.println("当前线程是：" + Thread.currentThread().getName() + "id:" + Thread.currentThread().getId());
        System.out.println("当前线程中获取的是：" + threadLocal.get());
        new Thread(() -> System.out.println("现在线程是：" + Thread.currentThread().getName() + "尝试获取" + threadLocal.get())).start();
    }
}
