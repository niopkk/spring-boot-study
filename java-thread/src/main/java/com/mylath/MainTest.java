package com.mylath;

/**
 * com.mylath
 * <p>
 * Created by tianxin2 on 2019/12/18
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        int worksNum = 100;
        MyLatch myLatch = new MyLatch(worksNum);
        for (int i = 0; i < worksNum; i++) {
            new Thread(new Works(myLatch)).start();
        }
        myLatch.await();
        System.out.println("sddsd");
    }
}
