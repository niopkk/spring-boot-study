package com.选择排序;

import java.util.Arrays;

/**
 * com.选择排序
 * <p>
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] ints = new int[]{8, 4, 9, 7, 5, 2, 6};
        selectSort(ints);
        System.out.print(Arrays.toString(ints));
        newSelectSort(ints);
        System.out.print(Arrays.toString(ints));
        ddSort(ints);
        System.out.print(Arrays.toString(ints));
    }


    static void selectSort(int... ints) {
        int length = ints.length;
        // i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for (int i = 0; i < length - 1; i++) {
            //minIndex 用来保存每次最小数的下标
            int minIndex = i;
            // j控制比较次数，因为每次循环结束之后最小的数都已经放在了最前面，
            // 所以下一次循环的时候就可以跳过这个数，所以j的初始值为i+1而不需要每次循环都从0开始，并且j<len即可
            for (int j = i + 1; j < length; j++) {
                if (ints[minIndex] > ints[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = ints[i];
                ints[i] = ints[minIndex];
                ints[minIndex] = temp;
            }
            // 打印每次循环结束之后数组的排序状态（方便理解）
            System.out.println("第" + (i + 1) + "次循环之后效果：" + Arrays.toString(ints));
        }
    }


    static void newSelectSort(int... ints) {
        int len = ints.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (ints[minIndex] > ints[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = ints[i];
                ints[i] = ints[minIndex];
                ints[minIndex] = temp;
            }
        }
    }

    static void ddSort(int... array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {

            int minIndex = i;
            for (int j = i; j < len; j++) {

                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

}
