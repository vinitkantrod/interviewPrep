package com.vinit.dsalgo.recursion.leetcode;

public class RemoveLinkedListElements203 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val  == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(7);
        System.out.println(removeElements(l, 1));
    }
}
