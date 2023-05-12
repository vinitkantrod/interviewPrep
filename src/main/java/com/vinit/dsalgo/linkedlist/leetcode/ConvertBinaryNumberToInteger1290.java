package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.List;

public class ConvertBinaryNumberToInteger1290 {

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            curr = curr.next;
        }
        System.out.println(sb.toString());
        char[] ch = sb.toString().toCharArray();
        int total = 0;
        int k = 0;
        for (int i = ch.length - 1; i >=0 ;i--) {
            total += (Math.pow(2, k) * (ch[i] - '0'));
            System.out.println(i + " - " + (Math.pow(2, k)) + " - " + total);
            k++;
        }
        return total;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(0);
        l.next.next = new ListNode(1);
        System.out.println(getDecimalValue(l));
    }
}
