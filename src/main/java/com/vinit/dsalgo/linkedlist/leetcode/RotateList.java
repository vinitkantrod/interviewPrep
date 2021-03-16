package com.vinit.dsalgo.linkedlist.leetcode;

public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    public static ListNode rotateRight(ListNode head, int k) {
        for (int i = 0; i < 6; i++) {
            System.out.print(test(i) + " ");
        }
        System.out.println(test(6));
        return head;
//        if (head.next == null || head == null) return head;
//        int len = 1;
//        ListNode tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//            len++;
//        }
//        int offset = Math.abs(k) % len;
//        if (offset == 0) return head;
//        int newTailPos = k > 0 ? len - offset : offset;
//        ListNode newTail = head;
//        for (int i = 1; i < newTailPos; i++) {
//            newTail = newTail.next;
//        }
//        tail.next = head;
//        head = newTail.next;
//        newTail.next = null;
//        return head;
    }

    public static int test(int n) {
        if (n== 1 || n == 2 || n == 0) return 0;
        if (n == 3) return 1;
        else {
            return test(n - 1) + test(n - 2) + test(n - 3);
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        traverse(rotateRight(l1, 2));
    }
}
