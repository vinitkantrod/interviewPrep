package com.vinit.dsalgo.linkedlist.leetcode;

import com.vinit.dsalgo.linkedlist.algoexpert.ReverseLL;

import java.util.List;

public class PalindromeLinkedList234 {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevOfSlowPtr = head;
        ListNode midNode = null;
        if (head == null || head.next == null) return true;
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
//        // Reverse the first Half
//        ListNode current = head;
//        ListNode nextNode = head.next;
//        ListNode prev = null;
//        while (nextNode != slow) {
//            System.out.println(":: " + current.val);
//            current.next = prev;
//            prev = current;
//            current = nextNode;
//            nextNode = nextNode.next;
//        }
//        System.out.println("- " + current.val);
//        ListNode left = head;
//        ListNode right = current.next;
//        System.out.println(">> " + right.val);
//        while (left.val == right.val) {
//            left = left.next;
//            right = right.next;
//        }
//        if (right != null) return false;
//        return true;
    }

    public static Boolean compareList(ListNode node1, ListNode node2) {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(l1));
    }
}
