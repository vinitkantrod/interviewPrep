package com.vinit.dsalgo.algoexpert.linkedlist;

public class ReverseLL {

    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
