package com.lesson2;

import com.bbz.util.Https;

/**
 * com.lesson2
 * <p>
 * Created by tianxin2 on 2019-06-26
 */
public class YCThread implements Runnable {
    @Override
    public void run() {

        while (true) {

            String s = Https.getInstance().get("https://www.xcode.me/");

            System.out.println(Thread.currentThread().getName());

            System.out.println(s);
        }

    }


    public static void main(String[] args) {
        YCThread ycThread = new YCThread();
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(ycThread, "线程" + i);

            thread.start();
        }
    }
}
