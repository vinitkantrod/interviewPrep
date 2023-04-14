package com.vinit.dsalgo.linkedlist.leetcode;

public class LinkedListCycleTwo142 {

    public static ListNode detectCycle(ListNode head) {
        // Own Solution

//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode cycleNode = null;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == null || slow == null) return null;
//            if (fast.val == slow.val) {
//                cycleNode = fast;
//                break;
//            }
//        }
//        System.out.println(cycleNode.val);
//        if (fast == null || fast.next == null) return null;
//        ListNode startNode = head;
//        while (startNode != cycleNode) {
//            startNode = startNode.next;
//            cycleNode = cycleNode.next;
//        }
//        return cycleNode;
//
        // LC sol
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;
        detectCycle(l1);
    }
}
