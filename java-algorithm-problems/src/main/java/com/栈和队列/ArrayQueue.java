package com.栈和队列;

import java.util.Arrays;

public class ArrayQueue {


    public static void main(String[] args) {

        Queue queue = new Queue(3);
        queue.addQueue(10);
        queue.addQueue(20);
        queue.addQueue(30);
        queue.showQueue();
        System.out.println("=====");
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println("=====");
        queue.showQueue();
    }
}

class Queue {
    private int maxSize;//表示数组最大容量

    private int front;//队头

    private int rear;//队尾

    private int[] arr;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front指向队列头的前一个位置。
        rear = -1;//指向队列尾部，指向队尾的数据(即队尾的最后一个数据)
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        Arrays.stream(arr).forEach(s -> System.out.printf("%d\n", s));
    }
}
