package com.bbz.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object n) {
        ensureCapacity();//扩容
        elements[size++] = n;
    }

    //这样有过期对象不能回收的情况，造成内存溢出
//    public Object pop() {
//        if (size == 0) {
//            throw new EmptyStackException();
//        }
//        return elements[--size];
//    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public int getLength() {
        return elements.length;
    }


    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {


        Stack stack = new Stack();

        for (int i = 0; i < 29; i++) {
            stack.push(i);
        }

        System.out.println("前：" + stack.getLength());
        for (int i = 0; i < 29; i++) {
            int s = (int) stack.pop();
            System.out.println(s);
        }
        System.out.println("后：" + stack.getLength());
    }
}
