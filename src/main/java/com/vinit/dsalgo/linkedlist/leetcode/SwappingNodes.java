package com.vinit.dsalgo.linkedlist.leetcode;

public class SwappingNodes {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode firstPtr = head;
        int fCount = 1;
//        if (fCount == k) return firstPtr;
        while (fCount < k) {
            firstPtr = firstPtr.next;
            fCount++;
        }
        System.out.println("fcount: " + fCount + ", node: " + firstPtr.val);
        ListNode slow = head;
        ListNode fast = head;
        int kthCount = 1;
        while (kthCount < k && fast != null) {
            fast = fast.next;
            kthCount++;
        }
        System.out.println("fast: " + fast.val);
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("before swap. A: " + firstPtr.val + " and B: " + slow.val + ", fast: " + fast.val);
        int temp = firstPtr.val;
        firstPtr.val = slow.val;
        slow.val = temp;
        System.out.println("after swap. A: " + firstPtr.val + " and B: " + slow.val);
        return head;
    }

    public static void traverse(ListNode h) {
        if (h == null) return;
        ListNode c = h;
        while (c != null) {
            System.out.print(c.val + " -> ");
            c = c.next;
        }
        System.out.print("Null");
    }
    public static void main(String args[]) {
        ListNode l = new ListNode(1,
                            new ListNode(2)
        );

        traverse(swapNodes(l, 1));
    }
}
