package com.vinit.dsalgo.linkedlist.leetcode;

public class IntersectionOfTwoLinkedList160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
            if (pA != null) System.out.print(pA.val);
            if (pB != null) System.out.println(" " + pB.val);
            System.out.println("----");
        }
        if (pA != null) System.out.println("pA: " + pA.val);
        return pA;
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
        int[] a = {4,1,8,4,5};
        int[] b = {5,6,1,8,4,5};
        ListNode pA = constructLL(a);
        ListNode pB = constructLL(b);
        System.out.println(getIntersectionNode(pA, pB));
    }

}
