package com.vinit.dsalgo.linkedlist.leetcode;

public class SortList148 {

    public static class ListNode {
        int val;
        ListNode next;
 ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);
        ListNode sorted = mergeSort(left, right);
        return sorted;
    }

    public static ListNode mergeSort(ListNode left, ListNode right) {
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

    public static ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        sortList(l1);
    }
}
