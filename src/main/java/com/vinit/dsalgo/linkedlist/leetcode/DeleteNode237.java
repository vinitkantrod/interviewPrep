package com.vinit.dsalgo.linkedlist.leetcode;

public class DeleteNode237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
