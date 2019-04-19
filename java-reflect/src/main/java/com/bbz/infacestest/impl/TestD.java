package com.bbz.infacestest.impl;

import com.bbz.infacestest.TestA;
import com.bbz.infacestest.TestB;

import java.util.function.Function;

public class TestD implements TestA {

    @Override
    public TestB go(String ss) {

        return new TestB() {
            @Override
            public <R> R extract(Function<String, R> function) {
                return function.apply(ss);
            }
        };
    }

    public static void main(String[] args) {


        String extract = new TestD().go("123123").extract(s -> s.replace("1", "*"));

        System.out.println(extract);

        String v = apply(s ->"0p0iiidf");

        System.out.println(v);

    }


    private static  <R> R apply(Function<Integer, R> function) {

        return function.apply(12);
    }

}
