package com.堆;

import com.bbz.util.Lists;

import java.util.Arrays;

/**
 * com.堆
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class TopKMain {

    public static void main(String[] args) {
        TopK<Integer> topK = new TopK<>(3);
        topK.addAll(Lists.of(100, 1, 2, 3, 34, 4, 5, 6, 23, 21, 90, 1));
        System.out.println(Arrays.toString(topK.toArray(new Integer[]{})));
        System.out.println(topK.getKth());
    }
}
