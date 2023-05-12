package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class RemoveNodeFromLinkedList2487 {

    static int maxVal = 0;
    public static ListNode removeNodes(ListNode head) {
        head = reverseLL(head);
        delete(head);
        head = reverseLL(head);
        return head;
    }

    public static void delete(ListNode head) {
        if (head == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        maxVal = Math.max(current.val, maxVal);
        while (current.next != null) {
            int val = current.next.val;
            if (maxVal > val) {
                current.next = current.next.next;
            } else {
                maxVal = val;
                current = current.next;
            }
        }
    }

    public static ListNode reverseLL(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
