package com.vinit.dsalgo.linkedlist.leetcode;

public class SwapNodesInPairs24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            curr = curr.next;
            if (curr == null) break;
            next = curr.next;
        }
        return dummy.next;

        // Clear code
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.

//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//
//        ListNode prevNode = dummy;
//
//        while ((head != null) && (head.next != null)) {
//
//            // Nodes to be swapped
//            ListNode firstNode = head;
//            ListNode secondNode = head.next;
//
//            // Swapping
//            prevNode.next = secondNode;
//            firstNode.next = secondNode.next;
//            secondNode.next = firstNode;
//
//            // Reinitializing the head and prevNode for next swap
//            prevNode = firstNode;
//            head = firstNode.next; // jump
//        }
//
//        // Return the new head node.
//        return dummy.next;
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

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }

    public static void main(String[] args ){
        int[] n = {1,2,3,4,5};
        ListNode l = constructLL(n);
        printLL(swapPairs(l));
    }
}
