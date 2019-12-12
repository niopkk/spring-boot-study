package com.洗牌;

import java.util.*;

/**
 * com.洗牌
 * <p>
 * Created by tianxin2 on 2019/12/12
 */
public class XiPai {


    public static void main(String[] args) {

        int[] array = new int[13];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        shuffle(array);
        System.out.println(Arrays.toString(array));

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void shuffle(int[] array) {
        Random rnd = new Random();
        for (int i = array.length; i > 1; i--) {
            int r = rnd.nextInt(i);//剩余的数组里面在随机一个下标，取数据 进行交换，保证不会取到已经取到的数据。
            swap(array, i - 1, r);
        }
    }
}
