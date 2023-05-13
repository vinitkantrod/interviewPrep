package com.vinit.dsalgo.linkedlist.leetcode;

public class MergeNodesBetweenZeros2181 {

    public ListNode mergeNodes(ListNode head) {
//        ListNode curr = head;
//        ListNode newNode = null;
//        ListNode newHead = null;
//        int sum = 0;
//        while (curr != null) {
//            if (curr.val == 0) {
//                if (sum > 0) {
//                    ListNode temp = new ListNode(sum);
//                    if (newHead == null) {
//                        newHead = temp;
//                        newNode = temp;
//                    } else {
//                        newNode.next = temp;
//                        newNode = temp;
//                    }
//                }
//                sum = 0;
//            }   else sum += curr.val;
//            curr = curr.next;
//        }
//        return newHead;

        ListNode node = head.next;
        ListNode nn = new ListNode();
        head = nn;

        int sum = 0;
        while(node != null) {
            if(node.val == 0) {
                nn.next = new ListNode(sum);
                nn = nn.next;
                sum = 0;
            } else {
                sum += node.val;
            }
            node = node.next;
        }
        return head.next;
    }
}
