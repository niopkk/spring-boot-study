package com.mylath;

/**
 * com
 * <p>
 * Created by tianxin2 on 2019/12/18
 */
public class MyLatch {
    private int count;

    public MyLatch(int count) {

        this.count = count;
        System.out.println("count:" + count);
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;
        System.out.println("count--:" + count);
        if (count <= 0) {
            notifyAll();
        }
    }
}
