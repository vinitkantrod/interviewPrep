package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class SortLinkedListAlreadySortedInAbsoluteValue2046 {

    public static ListNode sortLinkedList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        while (curr.next != null) {
            System.out.println("next: " + curr.next.val);
            if (curr.next.val > head.val) {
                curr = curr.next;
            } else {
                ListNode smaller = curr.next;
                curr.next = smaller.next;
                smaller.next = head;
                System.out.println(smaller.next.val);
                dummy.next = smaller;
                head = smaller;
            }
        }
        printLL(head);
        return head;
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
        int[] n = {0,-1,-1,-5};
        ListNode l = constructLL(n);
        System.out.println(sortLinkedList(l));
    }
}
