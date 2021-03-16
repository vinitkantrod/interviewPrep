package com.vinit.dsalgo.linkedlist.leetcode;

public class SplitLinkedListInParts {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void traverse(ListNode[] h) {
        if (h.length == 0) return;
        int x  = 0;
        for (ListNode i : h ) {
            System.out.println("x: " + x++);
            tra(i);
            System.out.println();
        }
    }

    public static void tra(ListNode h) {
        if (h == null) return;
        ListNode c = h;
        while (c != null) {
            System.out.print(c.val + " -> ");
            c = c.next;
        }
        System.out.print("Null");
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int kk = k;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            res[i] = null;
        }
        ListNode current = root;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        current = root;
        while (current != null) {
            int currLen = 0;
//            System.out.println(len + " :: " + k + "....." + Math.ceil(len / k));
            int totalEle = 0;
            if (len < k) totalEle = 1;
            else totalEle = (len + k - 1) / k;
            System.out.println((kk - k) + ", len: " + len + ", k: " + k + " - totalEle: " + totalEle);
            ListNode tempRes = null;
            ListNode tempHead = null;
            while (totalEle-- > 0) {
                tempRes = current;
                if (tempHead == null ) tempHead = tempRes;
                current = current.next;
                len--;
            }
            if (tempRes != null ) tempRes.next = null;
            res[kk - k] = tempHead;
            k--;
        }
        return res;
    }
    public static void main(String args[]) {
//        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(7);
//        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        traverse(splitListToParts(l2, 3));
    }
}
