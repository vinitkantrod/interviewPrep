package com.vinit.dsalgo.algoexpert.linkedlist;

public class SumOfLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(
            LinkedList linkedListOne, LinkedList linkedListTwo
    ) {
        if (linkedListOne == null) return linkedListTwo;
        if (linkedListTwo == null) return linkedListOne;
        LinkedList newListHead = null;
        LinkedList current = null;
        LinkedList first = linkedListOne;
        LinkedList second = linkedListTwo;
        int reminder = 0;
        while (first != null || second != null) {
            int value = 0;
            if (first != null) {
                value += first.value;
                first = first.next;
            }
            if (second != null) {
                value += second.value;
                second = second.next;
            }
            value = value + reminder;
            reminder = value / 10;
            value = value % 10;
            LinkedList temp = new LinkedList(value);
            if (newListHead == null) {
                newListHead = temp;
                current = temp;
            } else {
                current.next = temp;
                current = temp;
            }
        }
        if (reminder > 0) {
            current.next = new LinkedList(reminder);
        }
        // Write your code here.
        return newListHead;
    }
}
