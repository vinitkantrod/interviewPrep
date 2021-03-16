package com.vinit.dsalgo.linkedlist.leetcode;

public class MergeInBetween {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevOne = list1;
        ListNode nextOne = list1;
        ListNode prevTwo = list2;
        ListNode nextTwo = list2;
        while (nextTwo.next != null) {
            nextTwo = nextTwo.next;
        }
        int c = 1;
        while (c < a) {
            prevOne = prevOne.next;
            c++;
        }
        nextOne = prevOne.next;
        ListNode prev = prevOne;
        while (prev.val != b) {
            nextOne = nextOne.next;
            prev = prev.next;
        }
        prevOne.next = prevTwo;
        nextTwo.next = nextOne;
        prev.next = null;
        return list1;
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
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode ll1 = new ListNode(11);
        ListNode ll2 = new ListNode(21);
        ListNode ll3 = new ListNode(31);
        ListNode ll4 = new ListNode(41);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;

        traverse(mergeInBetween(l1, 3, 4, ll2));
    }
}
