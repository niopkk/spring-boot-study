package com.二分查找_有序数组;

import java.util.Arrays;

public class HighArray {

    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }


    /**
     * 选择查找
     */
    public void selectFind() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min])
                    min = in;
            }
            swap(out, min);
        }
    }

    public void print() {
        System.out.println(Arrays.toString(a));
    }

    public void swap(int one, int tow) {
        long temp = a[one];
        a[one] = a[tow];
        a[tow] = temp;
    }


    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return -1;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
//        int j;
//        for (j = 0; j < nElems; j++) {
//            if (a[j] > value) {
//                break;
//            }
//        }
//        for (int k = nElems; k > j; k--) {
//            a[k] = a[k - 1];
//        }
//        a[j] = value;
//        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j]) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
