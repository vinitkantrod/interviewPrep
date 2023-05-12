package com.vinit.dsalgo.linkedlist.leetcode;

public class DeleteMNodesAfterNNodes1474 {

    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        dummy.next = head;
        int mm = m;
        int nn = n;
        while (curr.next != null) {
            while (mm > 0 && curr.next != null) {
                curr = curr.next;
                mm--;
                System.out.println(curr.val);
            }
            ListNode temp = curr;
            while (nn > 0 && curr.next != null) {
                curr = curr.next;
                System.out.println("deleting: " + curr.val);
                nn--;
            }
            temp.next = curr.next;
            System.out.println(curr.val);
            mm = m;
            nn = n;
        }

        printLL(head);
        return head;
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
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        ListNode head = constructLL(arr);
        System.out.println(deleteNodes(head, 2, 3));
    }
}
