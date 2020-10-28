package com.java单链表;

public class SingLinkList {


    private int length;

    private Node head;

    public SingLinkList() {
        this.length = 0;
        this.head = null;
    }

    private class Node {

        private Object data;//节点数据

        private Node next;//指向下一个节点

        private Node(Object data) {
            this.data = data;
        }
    }

    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (length != 0) {
            newHead.next = head;
        }
        head = newHead;
        length++;
        return obj;
    }
}
