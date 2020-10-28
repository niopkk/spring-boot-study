package leetcode.环形链表_141;

import java.util.LinkedHashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}

class Solution {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = node;

        System.out.println(hasCycle(node));
    }


    public static boolean hasCycle(ListNode head) {
//        Set<ListNode> set=new LinkedHashSet<>();
//        while (head!=null){
//            if (set.contains(head)){
//                return true;
//            }
//            set.add(head);
//            head=head.next;
//        }
        //是否环形
        Set<ListNode> set = new LinkedHashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

