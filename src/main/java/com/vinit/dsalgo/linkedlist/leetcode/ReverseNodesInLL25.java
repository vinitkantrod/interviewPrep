package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class ReverseNodesInLL25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode prev = dummy;
        dummy.next = head;
        Boolean shouldCheck = true;
        int m = 1;
        while (curr.next != null) {
            if (shouldCheck && canReverse(curr.next, k)) {
                ListNode oldHead = curr.next;
                ListNode newGroupNode = getTailNextNode(curr.next, k);
                curr.next = reverse(curr.next, k);
                curr = oldHead;
                curr.next = newGroupNode;
            } else {
                curr = curr.next;
                shouldCheck = false;
            }
        }
        printLL(dummy.next);
        return dummy.next;
    }

    public static Boolean canReverse(ListNode node, int k) {
        if (k == 0) return true;
        if (node == null) return false;
        ListNode curr = node;
        while (k > 1 && curr != null) {
            curr = curr.next;
            k--;
        }
        if (k == 1 && curr != null) return true;
        return false;
    }

    public static ListNode getTailNextNode(ListNode node, int k) {
        if (node == null) return null;
        ListNode tail = node;
        while ((k) > 0 && tail != null) {
            tail = tail.next;
            k--;
        }
        return tail;

    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = k;
        while (count > 0 && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            System.out.println("RR prev: " + prev.val);
            curr = next;
            count--;
        }
        return prev;
    }

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }

    public static ListNode constructLL(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        for (int i : arr) {
            ListNode l = new ListNode(i);
            t.next = l;
            t = l;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6,7};
        ListNode l = constructLL(n);
        printLL(l);
        System.out.println(reverseKGroup(l, 7));
    }
}
