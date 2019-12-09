package com.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * com.callable
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new CallableThread());
        new Thread(task).start();

        System.out.println("【线程返回数据】:" + task.get());
        new Thread(task).start();


    }
}