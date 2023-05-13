package com.vinit.dsalgo.linkedlist.leetcode;

public class MergeInBetweenLL1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Head = list2;
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode curr = list1;
        ListNode prevPtr = null;
        ListNode endNode = null;
        int len = 0;
        while (curr.next != null) {
            if ((len + 1) == a) {
                prevPtr = curr;
            }
            if (len == b && prevPtr != null) {
                endNode = curr;
            }
            curr =curr.next;
            len++;
        }
        prevPtr.next = list2Head;
        list2Tail.next = endNode.next;
        return dummy.next;
    }
}
