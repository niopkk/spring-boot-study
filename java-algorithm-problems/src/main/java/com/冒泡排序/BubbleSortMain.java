package com.冒泡排序;

import java.util.Arrays;

/**
 * com.冒泡排序
 * <p>
 */
public class BubbleSortMain {


    public static void main(String[] args) {

        int[] ints = new int[]{8, 4, 9, 7, 5, 2, 6};
        System.out.println(ints[ints.length - 1]);
//        bubbleSort(ints);
//        System.out.print(Arrays.toString(ints));

        int[] ints1 = {1, 9768, 545, 2343, 523, 32, 59897, 534};
//        sor(ints1);
//        System.out.println(Arrays.toString(ints1));

        newSort(ints1);
        System.out.println(Arrays.toString(ints1));
        System.out.println(1);


        String[] t = new String[9];
        String[] strs = new String[]{"A", "B", "C"};
        String[] arrs = new String[]{"X", "Y", "Z"};

        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < arrs.length; j++) {
                t[index] = strs[i] + arrs[j];
                index++;
            }
        }
        System.out.println(Arrays.toString(t));

    }

    static void bubbleSort(int... ints) {
        //i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for (int i = 0; i < ints.length - 1; i++) {
            // j控制比较次数，第i次循环内需要比较len-i次
            // 但是由于是由arr[j]跟arr[j+1]进行比较，所以为了保证arr[j+1]不越界，j<len-i-1
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
    }

    static void sort(int... array) {

        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    static void sor(int... array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    static void newSort(int... array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {

                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
