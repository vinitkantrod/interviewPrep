package com.vinit.dsalgo.leetcode75.level1.linked_list;

public class RemoveNthNodeFromLL19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
//        ListNode n = new ListNode(1);
//        n.next = new ListNode(2);
//        n.next.next = new ListNode(3);
//        n.next.next.next = new ListNode(4);
//        n.next.next.next.next = new ListNode(5);
        ListNode n = new ListNode(1);
        System.out.println(removeNthFromEnd(n, 1));
    }
}
