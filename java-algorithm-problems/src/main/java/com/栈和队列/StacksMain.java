package com.栈和队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * com.栈和队列
 * <p>
 * Created by tianxin2 on 2019-05-16
 */
public class StacksMain {


    public static void main(String[] args) {


        Queue queue = new LinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.stream().forEach(q -> System.out.println("queue....." + q));
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println("stack...." + stack.pop());
        }


        Stacks stacks = new Stacks(10);

        stacks.push(10);
        stacks.push(20);
        stacks.push(30);
        stacks.push(40);
        stacks.push(50);
        stacks.push(60);
        stacks.push(70);
        stacks.push(80);
        stacks.push(90);
        stacks.push(100);

        while (!stacks.isEmpty()) {
            long pop = stacks.pop();


            System.out.println("pop:" + pop);
        }




    }
}
