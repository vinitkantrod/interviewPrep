package com.vinit.dsalgo.algoexpert.linkedlist;

public class MergeLL {
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(
            LinkedList headOne, LinkedList headTwo
    ) {
        // Write your code here.
        LinkedList newHead = null;
        LinkedList curr = null;
        LinkedList first = headOne;
        LinkedList second = headTwo;
        while (first != null && second != null) {
            LinkedList temp = null;
            if (first.value > second.value) {
                temp = first;
                first = first.next;
            } else {
                temp = second;
                second = second.next;
            }
            if (newHead == null) {
                newHead = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = temp;
            }
        }
        if (first != null) {
            curr.next = first;
        }
        if (second != null) {
            curr.next = second;
        }
        return newHead;
    }
}
