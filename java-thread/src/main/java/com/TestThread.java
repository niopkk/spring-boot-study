package com;

import java.util.ArrayList;
import java.util.List;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        AccessToken accessToken1 = new TestThread().new AccessToken();

        Mythread mythread1 = new Mythread(accessToken1);
        for (int i = 0; i < 3; i++) {

            new Thread(mythread1, String.valueOf(i)).start();


        }
    }


    static class Mythread implements Runnable {

        private AccessToken accessToken;

        public Mythread(AccessToken accessToken) {
            this.accessToken = accessToken;
        }

        @Override
        public void run() {
            System.out.println("threadName:" + Thread.currentThread().getName());
            while (true) {
                if (accessToken.isExpires()) {
                    System.out.println(Thread.currentThread().getName() + "token未过期");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    long current = System.currentTimeMillis() + (long) ((30 - 10) * 1000);
                    accessToken.setExpiresTime(current);
                    System.out.println(Thread.currentThread().getName() + "设置过期时间-----" + current);
                }
            }

        }
    }


    class AccessToken {

        private long expiresTime;

        private boolean isExpires() {
            long current = System.currentTimeMillis();
//            System.out.println("current:" + current + "\nexpiresTime:" + this.expiresTime);
            return current <= this.expiresTime;
        }

        public long getExpiresTime() {
            return expiresTime;
        }

        public void setExpiresTime(long expiresTime) {
            this.expiresTime = expiresTime;
        }
    }
}
