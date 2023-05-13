package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class PlusOneLinkedList369 {

    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverseList(head);
        addOne(newHead);
        return reverseList(newHead);
    }

    public static void addOne(ListNode head) {
        int carry = 0;
        if ((head.val + 1) < 9) {
            head.val = head.val + 1;
            return;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        Boolean oneAdded = false;
        while (curr != null) {
            curr.val = curr.val + carry;
            if (!oneAdded) {
                curr.val += 1;
                oneAdded = true;
            }
            if (curr.val > 9) {
                curr.val = curr.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr = curr.next;
            prev = prev.next;
        }
        if (carry == 1) {
            ListNode n = new ListNode(carry);
            prev.next = n;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
