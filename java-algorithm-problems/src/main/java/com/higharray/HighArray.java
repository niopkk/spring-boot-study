package com.higharray;

/**
 * com.higharray
 * <p>
 * Created by tianxin2 on 2019-05-15
 */
public class HighArray {


    private long[] array;

    private int elem;


    public HighArray(int max) {
        array = new long[max];
        elem = 0;
    }

    public boolean find(int seachKey) {
        int j;
        for (j = 0; j < elem; j++) {
            if (array[j] == seachKey) {
                break;
            }
        }
        if (j == elem) {
            return false;
        } else {
            return true;
        }
    }

    //二分查找方法(数组必须是有序数组，否则查不出来)
    public int finds(int seachKey) {
        int lowerBound = 0;
        int upperBound = elem - 1;
        int curIndex;
        while (true) {
            curIndex = (lowerBound + upperBound) / 2;
            if (array[curIndex] == seachKey) {
                return curIndex;
            } else if (lowerBound > upperBound) {
                return elem;
            } else {
                if (array[curIndex] < seachKey) {
                    lowerBound = curIndex + 1;
                } else {
                    upperBound = curIndex - 1;
                }
            }
        }
    }

    public void insert(long value) {
        array[elem] = value;
        elem++;
    }

    public boolean del(long value) {
        int j;
        for (j = 0; j < elem; j++) {
            if (value == array[j]) {
                break;
            }
        }
        if (j == elem) {
            return false;
        } else {
            //要删除的值的索引位置，后面的值要向前移动+1
            for (int k = j; k < elem; k++) {
                array[k] = array[k + 1];
            }
            elem--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < elem; i++) {
            System.out.println(array[i]);
        }
    }
}
