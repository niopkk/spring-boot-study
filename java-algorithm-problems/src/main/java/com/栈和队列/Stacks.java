package com.栈和队列;

/**
 * com.栈和队列
 * <p>
 * Created by tianxin2 on 2019-05-16
 */
public class Stacks {

    private int maxSize;

    private long[] stackArray;

    private int top;

    public Stacks(int max) {
        maxSize = max;
        stackArray = new long[max];
        top = -1;
    }

    public void push(long j) {
        stackArray[++top] = j;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
