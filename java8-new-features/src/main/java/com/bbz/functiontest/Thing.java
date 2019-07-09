package com.bbz.functiontest;

/**
 * com.bbz.functiontest
 * <p>
 * Created by tianxin2 on 2019-07-09
 */
public class Thing {

    private static final Thing[] VALUES = {new Thing(1), new Thing(3)};

    public static Thing[] values() {
        return VALUES.clone();
    }


    private int num;

    public Thing(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "num=" + num +
                '}';
    }
}
