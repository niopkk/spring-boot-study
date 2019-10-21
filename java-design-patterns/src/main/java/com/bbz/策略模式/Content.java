package com.bbz.策略模式;

/**
 * com.bbz.策略模式
 * <p>
 * Created by tianxin2 on 2019/10/21
 */
public class Content {

    private Strategy strategy;

    public Content(Strategy strategy) {
        this.strategy = strategy;
    }

    public int exec(int x, int y) {
        return strategy.add(x, y);
    }
}
