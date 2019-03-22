package com.interrupt;

public class InterruptMyThread extends Thread {


    @Override
    public void run() {
        //线程停止不了
        super.run();
//        for (int i = 0; i < 5000000; i++) {
//
//            if (this.isInterrupted()) {
//                System.out.println("线程停止工作........退出线程.........");
//                break;
//            }
//
//            System.out.println("i=" + (i + 1));
//        }
//        System.out.println("看到这句话说明线程并未终止------");
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("ֹͣ停止了!");
                return;
            }
            System.out.println("timer=" + System.currentTimeMillis());
        }
    }
}
