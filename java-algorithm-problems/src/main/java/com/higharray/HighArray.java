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
