package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * com.callable
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("*********线程执行了 i=" + i);
        }
        return "线程执行完毕";
    }



}
