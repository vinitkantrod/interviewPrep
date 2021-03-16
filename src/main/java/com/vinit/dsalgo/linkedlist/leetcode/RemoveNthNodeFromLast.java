package com.vinit.dsalgo.linkedlist.leetcode;

public class RemoveNthNodeFromLast {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (n == 1 && head.next == null) return null;
        ListNode one = head;
        ListNode two = head;
        int c = 1;
        while (c <= n && two != null) {
            two = two.next;
            c++;
        }
        // If n == lenth of LL.
        if (two == null) {
            ListNode h = head.next;
            head.next = null;
            head = h;
            return head;
        }
        while (two != null) {
            one = one.next;
            two = two.next;
        }
        if (one.next != null) one.next = one.next.next;
        return head;
    }

    public static void traverse(ListNode h) {
        if (h == null) return;
        ListNode c = h;
        while (c != null) {
            System.out.print(c.val + " -> ");
            c = c.next;
        }
        System.out.print("Null");
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        traverse(removeNthFromEnd(l1, 2));
    }
}
