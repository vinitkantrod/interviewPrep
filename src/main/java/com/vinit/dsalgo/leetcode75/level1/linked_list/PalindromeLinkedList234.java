package com.vinit.dsalgo.leetcode75.level1.linked_list;

public class PalindromeLinkedList234 {

    public Boolean pairSum(ListNode head) {
        if (head == null || head.next == null) return true;
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
    public Boolean compareList(ListNode node1, ListNode node2) {
        ListNode first = node1;
        ListNode second = node2;
        while (first != null && second != null) {
            if (first.val == second.val) {
                first = first.next;
                second = second.next;
            }
            else return false;
        }
        if (first == null && second == null) return true;
        return false;
    }
}
