package com.bbz.策略模式;

/**
 * com.bbz.策略模式
 * <p>
 * Created by tianxin2 on 2019/10/21
 */
public class MainTest {

    public static void main(String[] args) {
        int exec = new Content(new Shop()).exec(1, 2);
        System.out.println(exec);
    }
}
