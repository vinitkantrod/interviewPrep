package com.vinit.dsalgo.algoexpert.linkedlist;

public class MergingLL {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(
            LinkedList linkedListOne, LinkedList linkedListTwo
    ) {
        // Write your code here.
        LinkedList pA = linkedListOne;
        LinkedList pB = linkedListTwo;
        while (pA != pB) {
            pA = pA == null ? linkedListTwo : pA.next;
            pB = pB == null ? linkedListOne : pB.next;
        }
        return pA;
    }
}
