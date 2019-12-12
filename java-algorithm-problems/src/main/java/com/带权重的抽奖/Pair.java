package com.带权重的抽奖;

/**
 * com.带权重的抽奖
 * <p>
 * Created by tianxin2 on 2019/12/12
 */
public class Pair<T> {
    public T item;

    public int weight;

    public Pair(T item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public Object getItem() {
        return item;
    }

    public int getWeight() {
        return weight;
    }
}
