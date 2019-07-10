package com.bbz.supplier;

import java.util.function.Supplier;

/**
 * com.bbz.supplier
 * <p>
 * Created by tianxin2 on 2019-07-10
 */
public class Supper {

    private final Dictionary dic;

    public Supper(Supplier<Dictionary> factory) {
        this.dic = factory.get();
    }

    public void say() {
        dic.findWord();
    }
}
