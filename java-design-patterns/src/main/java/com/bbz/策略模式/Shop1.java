package com.bbz.策略模式;

/**
 * com.bbz.策略模式
 * <p>
 * Created by tianxin2 on 2019/10/23
 */
public class Shop1 implements Strategy {
    @Override
    public int add(int x, int y) {
        return x - y;
    }
}
