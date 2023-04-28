package com.vinit.dsalgo.leetcode75.level1.linked_list;

public class MaximumTwinSum2130 {

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevOfSlowPtr = head;
        ListNode midNode = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevOfSlowPtr = slow;
            slow = slow.next;
        }
        if (fast != null) {
            midNode = slow;
            slow = slow.next;
        }
        ListNode secondHalf = slow;
        prevOfSlowPtr.next = null;
        // reverse second half
        ListNode prev = null;
        ListNode current = secondHalf;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        secondHalf = prev;
        return compareList(head, secondHalf);
    }
    public static Integer compareList(ListNode node1, ListNode node2) {
        ListNode first = node1;
        ListNode second = node2;
        Integer max = Integer.MIN_VALUE;
        while (first != null && second != null) {
            int val = first.val + second.val;
            if (val > max) max = val;
            first = first.next;
            second = second.next;
        }
        return max;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(4);
        n.next = new ListNode(2);
        n.next.next = new ListNode(10);
        n.next.next.next = new ListNode(11);
        n.next.next.next.next = new ListNode(2);
        n.next.next.next.next.next = new ListNode(3);
        System.out.println(pairSum(n));
    }
}
