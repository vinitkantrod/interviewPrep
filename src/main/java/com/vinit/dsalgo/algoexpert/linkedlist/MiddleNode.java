package com.vinit.dsalgo.algoexpert.linkedlist;

public class MiddleNode {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        // Write your code here.
        LinkedList slow = linkedList;
        LinkedList fast = linkedList;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
