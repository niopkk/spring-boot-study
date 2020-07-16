package com.冒泡排序;

import java.util.Arrays;

public class NewBubbleSortMain {

    public static void main(String[] args) {
        int[] array = new int[]{0, 3, 2, 1, 8, 6, 4, 7, 9};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        int x = 0, y = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                if (array[i] < array[j]) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//
//                }
//                y++;
//            }
//            x++;
//        }
        int z = 0, k = 0;
        int out, in;
        for (out = array.length - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] < array[in + 1]) {
                    int temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
                k++;
            }
            z++;
        }
        System.out.println("x:" + x + "y:" + y);
        System.out.println("z:" + z + "k:" + k);
        System.out.println(Arrays.toString(array));
    }

}
