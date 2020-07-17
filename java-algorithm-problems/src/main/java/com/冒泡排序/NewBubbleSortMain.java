package com.冒泡排序;

import java.util.Arrays;

public class NewBubbleSortMain {

    public static void main(String[] args) {
        int[] array = new int[]{0, 3, 2, 1, 8, 6, 4, 7, 9};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6};
//        int x = 0, y = 0;
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
//        int out, in;
//        for (out = array.length - 1; out > 0; out--) {
//            for (in = 0; in < out; in++) {
//                if (array[in] < array[in + 1]) {
//                    int temp = array[in];
//                    array[in] = array[in + 1];
//                    array[in + 1] = temp;
//                }
//            }
//        }




        int out, in, min;
        for (out = 0; out < array.length - 1; out++) {
            min = out;
            for (in = out + 1; in < array.length; in++) {
                if (array[in] < array[min]) {
                    min = in;
                }
            }
            int temp = array[out];
            array[out] = array[min];
            array[min] = temp;
        }
        System.out.println(Arrays.toString(array));
    }


}
