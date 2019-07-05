package com.bbz.designtest;

import com.bbz.designtest.impl.FetchersImpl;
import com.bbz.designtest.model.FetchJob;

/**
 * com.bbz.designtest
 * <p>
 * Created by tianxin2 on 2019-07-04
 */
public class MainTest {


    private static Fetchers fetchers = new FetchersImpl();

    public static void main(String[] args) {

        FetchJob ds = fetchers.createJob(builder -> builder.withType("ds"));
        System.out.println(ds.toString());
    }
}
