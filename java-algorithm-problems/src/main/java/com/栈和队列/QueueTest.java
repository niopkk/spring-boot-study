package com.栈和队列;

public class QueueTest {

    String[] array;

    int n;

    int head;

    int tail;

    public QueueTest(int n) {
        this.n = n;
        this.array = new String[n];
    }


    public boolean ru(String value) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                array[i - head] = array[i];
            }
            tail -= head;
            head = 0;
        }
        array[tail] = value;
        ++tail;
        return true;
    }

    public String pop() {
        if (head == 0 && head == tail) {
            return null;
        }
        String result = array[head];
        ++head;
        return result;
    }

    public static void main(String[] args) {

        QueueTest queueTest = new QueueTest(3);

        queueTest.ru("1");
        queueTest.ru("2");
        queueTest.ru("3");

        for (int i = 0; i < 3; i++) {
            System.out.println(queueTest.pop());
        }



    }

}
