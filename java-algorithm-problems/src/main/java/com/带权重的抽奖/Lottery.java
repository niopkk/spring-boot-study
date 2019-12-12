package com.带权重的抽奖;

/**
 * com.带权重的抽奖
 * <p>
 * Created by tianxin2 on 2019/12/12
 */
public class Lottery {

    public static void main(String[] args) {
        Pair[] pairs = new Pair[]{
                new Pair("1元", 7),
                new Pair("5元", 2),
                new Pair("10元", 1),
        };
        WeightRandom weightRandom = new WeightRandom(pairs);
        for (int i = 0; i < 1000; i++) {
            System.out.println(weightRandom.nextItem()+" ");
        }
    }
}
