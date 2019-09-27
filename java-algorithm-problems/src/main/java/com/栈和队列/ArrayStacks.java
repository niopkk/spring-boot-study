package com.栈和队列;

/**
 * com.栈和队列
 * <p>
 * Created by tianxin2 on 2019-09-27
 */
public class ArrayStacks {

    private int[] items;

    private int n;

    private int count;

    public ArrayStacks(int n) {
        this.items = new int[n];
        this.n = n;
        this.count = 0;
    }

    public void push(int item) {
        if (count == n) {
            //相等2倍的方式进行扩容
            n = n * 2;
            int[] temps = new int[n];
            for (int i = 0; i < items.length; i++) {
                temps[i] = items[i];
            }
            //清空原数组
            items = null;
            //扩容原items数组
            items = new int[n];
            //重新赋值
            items = temps;
        }
        items[count] = item;
        ++count;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        int tem = items[count - 1];
        --count;
        return tem;
    }
}
