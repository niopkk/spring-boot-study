package com.bbz.supplier;

import com.bbz.supplier.impl.ChDictionary;
import com.bbz.supplier.impl.EnDictionary;

/**
 * com.bbz.supplier
 * <p>
 * Created by tianxin2 on 2019-07-10
 */
public class SupperlierMainTest {
    public static void main(String[] args) {


        Supper supper = new Supper(() -> new ChDictionary());

        Supper supper1 = new Supper(() -> new EnDictionary());

        supper.say();

        supper1.say();

    }
}
