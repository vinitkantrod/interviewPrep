package com.vinit.dsalgo.linkedlist.algoexpert;

public class FindIntersection {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int c1 = getCount(linkedListOne);
        int c2 = getCount(linkedListTwo);
        if (c1 > c2) {
            int d = c1 - c2;
            return getIntersection(d, linkedListOne, linkedListTwo);
        } else {
            int d = c2 - c1;
            return getIntersection(d, linkedListTwo, linkedListOne);
        }

    }

    public LinkedList getIntersection(int d, LinkedList node1, LinkedList node2) {
        int i = 0;
        LinkedList current1 = node1;
        LinkedList current2 = node2;
        for (; i < d; i++) {
            if (current1 == null) return null;
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1 == current2) return current1;
            current1 = current1.next;
            current2 = current2.next;
        }
        return null;
    }

    public int getCount(LinkedList node) {
        LinkedList current = node;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
