package leetcode.反转链表_206;

import java.util.LinkedHashSet;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        System.out.println(reverseList(node));
    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //第一步将链表中的第一个的节点的后继节点全部取出来，暂存在temp中：
            //数据如下:ListNode 2,ListNode 3 全部都在temp中
            ListNode temp = curr.next;
            //第二步
            //第一次循环将链表中的头节点的后置节点设置为null，变成尾节点
            //剩下的循环依次取出剩下节点，给prev设置next后置节点
            curr.next = prev;
            //第三步，将当前的数据给到prev，因为第一次后置节点为null
            //后置节点数据都由上一步curr.next设置它的后置节点
            prev = curr;
            //第四步
            //将剩下的节点数据重新给到curr再次循环。
            curr = temp;
        }

        return prev;
    }


}