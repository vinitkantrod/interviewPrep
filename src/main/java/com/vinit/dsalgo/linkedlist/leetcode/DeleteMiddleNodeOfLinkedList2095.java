package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class DeleteMiddleNodeOfLinkedList2095 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;

        // Initialize two pointers, 'slow' and 'fast'.
        ListNode slow = head, fast = head.next.next;

        // Let 'fast' move forward by 2 nodes, 'slow' move forward by 1 node each step.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When 'fast' reaches the end, remove the next node of 'slow' and return 'head'.
        slow.next = slow.next.next;
        return head;
    }

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next = new ListNode(3);
        System.out.println(deleteMiddle(l));
    }
}
