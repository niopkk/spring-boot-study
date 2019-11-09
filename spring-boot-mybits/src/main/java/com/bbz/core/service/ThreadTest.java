package com.bbz.core.service;

import com.bbz.core.entity.ThreadEntity;

/**
 * com.bbz.core.service
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
public class ThreadTest implements Runnable {


    private ThreadService threadService;

    public ThreadTest(ThreadService threadService) {
        this.threadService = threadService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("进入线程:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadEntity threadEntity = new ThreadEntity();
            threadEntity.setName("service.... thread");
            threadEntity.setId(1);
            threadEntity.setDes("线程");
            threadService.update(threadEntity);
        }

    }
}
