package com.bbz.策略模式;

/**
 * com.bbz.策略模式
 * <p>
 * Created by tianxin2 on 2019/10/21
 */
public class Shop implements Strategy {


    @Override
    public int add(int x, int y) {
//        System.out.println("1111");
        return x + y;
    }
}
