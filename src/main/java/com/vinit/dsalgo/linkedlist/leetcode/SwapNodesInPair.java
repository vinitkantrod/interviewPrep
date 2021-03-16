package com.vinit.dsalgo.linkedlist.leetcode;

import com.sun.istack.internal.NotNull;

public class SwapNodesInPair {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head, int k) {
        if (head == null) return null;
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        // Check if K nodes are present in the LL or not.
        int tCount = 0;
        ListNode tCurrent = head;
        while (tCurrent != null && tCount < k) {
            tCurrent = tCurrent.next;
            tCount++;
        }
        if (tCount != k) return head;
        int count = 0;
        while (current != null & count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = swapPairs(next, k);
        }
        return prev;
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        traverse(swapPairs(l1, 3));
    }
}
