package com.ThreadLocal;

import java.util.concurrent.ConcurrentHashMap;

/**
 * com.ThreadLocal
 * <p>
 * Created by tianxin2 on 2019-05-13
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        CodeBearThreadLocal threadLocal = new CodeBearThreadLocal();
        threadLocal.set("Hello");

        System.out.println("当前线程是：" + Thread.currentThread().getName());
        System.out.println("在当前线程中获取：" + threadLocal.get());
        new Thread(() -> System.out.println("现在线程是" + Thread.currentThread().getName() + "尝试获取：" + threadLocal.get())).start();

    }


    static class CodeBearThreadLocal<T> {

        private ConcurrentHashMap<Long, T> hashMap = new ConcurrentHashMap<>();

        void set(T value) {
            hashMap.put(Thread.currentThread().getId(), value);
        }

        T get() {
            return hashMap.get(Thread.currentThread().getId());
        }

    }
}
