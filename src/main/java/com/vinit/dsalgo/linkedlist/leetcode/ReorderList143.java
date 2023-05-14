package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class ReorderList143 {

    public static void reorderList(ListNode head) {
        if (head == null) return;
        if (head.next == null) return;
        ListNode h1 = head;
        ListNode h2 = null;
        // Split LL
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            h2 = prev.next;
            prev.next = null;
        }
        else {
            h2 =  slow.next;
            slow.next = null;
        }
        h2 = reverse(h2);
        printLL(h1);
        printLL(h2);
        ListNode newHead = h1;
        h1 = h1.next;
        Boolean addH2 = true;
        while (h1 != null && newHead != null) {
            if (addH2) {
                newHead.next = h2;
                h2 = h2.next;
                addH2 = false;
            } else {
                newHead.next = h1;
                h1 = h1.next;
                addH2 = true;
            }
            newHead = newHead.next;
        }
        if (h2 != null) newHead.next = h2;
        printLL(head);
    }

    public static ListNode splitLL(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) return prev.next;
        return slow.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }

    public static ListNode constructLL(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        for (int i : arr) {
            ListNode l = new ListNode(i);
            t.next = l;
            t = l;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4};
        ListNode l = constructLL(n);
        printLL(l);
        reorderList(l);
    }
}
