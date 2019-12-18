package com.mylath;

/**
 * com.mylath
 * <p>
 * Created by tianxin2 on 2019/12/18
 */
public class Works implements Runnable {

    private MyLatch latch;

    public Works(MyLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) Math.random() * 1000);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
