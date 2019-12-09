package com.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    static AtomicReference<String> str = new AtomicReference<>("abc");


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(Math.abs((int) Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (str.compareAndSet("abc", "def")) {
                    System.out.println("Thread ..." + Thread.currentThread().getId() + "change success");
                } else {
                    System.out.println("Thread ..." + Thread.currentThread().getId() + "change fail");
                }
            }).start();
        }
    }
}