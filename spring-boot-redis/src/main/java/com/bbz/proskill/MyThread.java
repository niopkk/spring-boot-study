package com.bbz.proskill;

public class MyThread implements Runnable {

    private Service service;


    public MyThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}
