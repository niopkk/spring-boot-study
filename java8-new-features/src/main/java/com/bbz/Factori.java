package com.bbz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/11/27
 */
public class Factori {

    public static void main(String[] args) {
//        System.out.println(new Factori().fact.apply(5));



        Factori factori=new Factori();
        System.out.println(factori.toString());


    }

    //24-32
    private UnaryOperator<Integer> fact = x -> ((x == 1 || x == 0) ? 1 : x * this.fact.apply(x - 1));
}