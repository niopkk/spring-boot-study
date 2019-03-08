package com.testrestfull;

import java.util.concurrent.CountDownLatch;

public class TestMain implements Runnable {


    private final CountDownLatch countDownLatch;

    public TestMain(CountDownLatch countDownLatch) {
        super();
        this.countDownLatch = countDownLatch;
    }

    int i = 0;
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //do
//        String ss = Https.getInstance().get("https://suggest.taobao.com/sug?code=utf-8&q=%E5%8D%AB%E8%A1%A3&callback=cb");
//        System.out.println(ss);


    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 1000; i > 0; i--) {
            new Thread(new TestMain(countDownLatch)).start();
            System.out.println(i++);
        }
        countDownLatch.countDown();
    }


}
