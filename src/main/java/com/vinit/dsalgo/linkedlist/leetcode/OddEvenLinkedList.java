package com.vinit.dsalgo.linkedlist.leetcode;

public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode oddEvenList(ListNode head) {
//        if (head == null || head.next == null ) return head;
//        ListNode even = null;
//        ListNode evenStart = null;
//        ListNode odd = null;
//        ListNode oddStart = null;
//        ListNode current = head;
//        while (current != null) {
//            if (current.val % 2 == 1) {
//                if (odd == null) {
//                    odd = current;
//                    oddStart = odd;
//                } else {
//                    odd.next = current;
//                    odd = current;
//                }
//            } else {
//                if (even == null) {
//                    even = current;
//                    evenStart = even;
//                } else {
//                    even.next = current;
//                    even = current;
//                }
//            }
//            System.out.println("current: " + current.val);
//            if (odd != null)
//                System.out.println("odd: " + odd.val);
//            if (even != null)
//                System.out.println("even: " + even.val);
//            if (current.val == 5) break;
//            current = current.next;
//        }
//        odd.next = evenStart;
//        return oddStart;

        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
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

    public static void main(String args[]) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        traverse(l1);
        traverse(oddEvenList(l1));
    }
}
