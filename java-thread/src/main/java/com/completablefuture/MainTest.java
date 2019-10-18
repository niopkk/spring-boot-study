package com.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * com.completablefuture
 * <p>
 * Created by tianxin2 on 2019/10/18
 */
public class MainTest {

    // 参考链接   https://segmentfault.com/a/1190000014479792#articleHeader0
    public static void main(String[] args) {
//        CompletableFuture<String> future = new CompletableFuture<>();
//
//        try {
//            final String s = future.get();
//
//            System.out.println(s);
//            future.complete("211");
//
//            System.out.println(s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//
//
//        }

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result of the asynchronous computation";
        });

        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
