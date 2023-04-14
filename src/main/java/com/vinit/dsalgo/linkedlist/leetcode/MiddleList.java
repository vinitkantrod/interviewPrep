package com.vinit.dsalgo.linkedlist.leetcode;

import com.vinit.dsalgo.linkedlist.algoexpert.MiddleNode;

public class MiddleList {

        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
}
