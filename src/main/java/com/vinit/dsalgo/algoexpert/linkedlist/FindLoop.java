package com.vinit.dsalgo.algoexpert.linkedlist;

public class FindLoop {

    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList slow = head.next;
        LinkedList fast = head.next.next;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
