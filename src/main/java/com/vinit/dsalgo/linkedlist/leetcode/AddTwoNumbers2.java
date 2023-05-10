package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class AddTwoNumbers2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

 }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Boolean remainder = false;
        Boolean letsBreak = false;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        int count1 = 0;
        int count2 = 0;
        while (l1 != null) {
            count1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            count2++;
            l2 = l2.next;
        }
        if (count1 >= count2) {
            return sum(l1Head, l2Head);
        } else {
            return sum(l2Head, l1Head);
        }

//        int num1 = 0;
//        int num2 = 0;
//        while (l1 != null) {
//            num1 = num1 * 10 + l1.val;
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            num2 = num2 * 10 + l2.val;
//            l2 = l2.next;
//        }
//        System.out.println(num1 + " - " + num2);
//        int num3 = num1 + num2;
//        ListNode head = new ListNode();
//        ListNode temp = new ListNode();
//        while (num3 != 0) {
//            int last = num3 % 10;
//            ListNode l = new ListNode(last);
//            if (head == null) {
//                head = l;
//            } else {
//                temp.next = l;
//            }
//            temp = l;
//            num3 = num3 / 10;
//        }
//        return head;
    }

    public static ListNode sum(ListNode l1, ListNode l2) {
        int remainder = 0;
        ListNode head = l1;
        while (l1 != null) {
            if (l2 != null) {
                int n = l1.val + l2.val + remainder;
                if (n > 9) {
                    remainder = 1;
                    n = n / 10;
                } else remainder = 0;
                l1.val = n;
                l2 = l2.next;
            } else {
                int n = l1.val + remainder;
                if (n > 9) {
                    remainder = 1;
                    n = n / 10;
                } else remainder = 0;
                l1.val = n;
            }
            l1 = l1.next;
        }
        if (remainder > 0 && l1 == null) {
            l1.next = new ListNode(remainder);
        }
        return head;
    }
    public static void printList(ListNode n)
    {
        while (n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l = addTwoNumbers(l1, l2);
        printList(l);
    }
}
