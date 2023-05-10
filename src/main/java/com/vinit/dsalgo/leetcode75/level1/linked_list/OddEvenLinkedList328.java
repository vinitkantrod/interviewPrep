package com.vinit.dsalgo.leetcode75.level1.linked_list;

public class OddEvenLinkedList328 {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddNext = odd;
        ListNode evenNext = even;
        while (evenNext != null) {
//            System.out.println(oddNext.val + " - " + evenNext.val);
            oddNext.next = evenNext.next;
            if (oddNext.next == null) break;
            oddNext = oddNext.next;
//            System.out.println("new odd Val: " + oddNext.val);
            evenNext.next = oddNext.next;
            evenNext = evenNext.next;
        }
        oddNext.next = even;
        ListNode iterate = odd;
//        while (iterate != null) {
//            System.out.println(iterate.val);
//            iterate = iterate.next;
//        }
        return odd;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(6);
        System.out.println(oddEvenList(l));
    }
}
