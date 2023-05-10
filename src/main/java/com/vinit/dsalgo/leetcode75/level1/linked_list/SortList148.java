package com.vinit.dsalgo.leetcode75.level1.linked_list;

public class SortList148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);
        ListNode sorted = mergeSort(left, right);
        return sorted;
    }
    public ListNode mergeSort(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode result = null;
        if (left.val < right.val) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }
        return result;
    }
    public ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
