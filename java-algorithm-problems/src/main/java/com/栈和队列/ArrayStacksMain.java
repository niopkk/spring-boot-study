package com.栈和队列;

/**
 * com.栈和队列
 * <p>
 * Created by tianxin2 on 2019-09-27
 */
public class ArrayStacksMain {

    public static void main(String[] args) {
        ArrayStacks arrayStacks = new ArrayStacks(2);
        arrayStacks.push(3);
        arrayStacks.push(2);
        arrayStacks.push(1);
        arrayStacks.push(8);
        arrayStacks.push(9);


        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());




    }
}
