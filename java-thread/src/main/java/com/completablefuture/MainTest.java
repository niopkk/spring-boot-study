package com.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * com.completablefuture
 * <p>
 * Created by tianxin2 on 2019/10/18
 */
public class MainTest {

    // 参考链接   https://segmentfault.com/a/1190000014479792#articleHeader0
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        try {
            final String s = future.get();

            System.out.println(s);
            future.complete("211");

            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();


        }
    }
}
