package com.enummap;

import com.bbz.util.Lists;

import java.util.List;

/**
 * com.enummap
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class EnumMap {

    public static void main(String[] args) {


        final List<Clothes> clothes = Lists.of(new Clothes("C001", Size.LARGE));
        System.out.println(Clothes.countBySize(clothes));


    }
}
