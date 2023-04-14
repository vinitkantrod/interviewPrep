package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class RemoveDuplicateFromSortedList83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (currentNode.val != nextNode.val) {
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            } else {
                currentNode.next = nextNode.next;
                nextNode.next = null;
                nextNode = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
