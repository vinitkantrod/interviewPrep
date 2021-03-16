package com.vinit.dsalgo.linkedlist.algoexpert;

public class SumOfLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        if (linkedListOne == null) return linkedListTwo;
        if (linkedListTwo == null) return linkedListOne;
        LinkedList current = null;
        LinkedList newListHead = null;
        LinkedList first = linkedListOne;
        LinkedList second = linkedListTwo;
        int reminder = 0;
        while (first != null || second != null) {
            int value = 0;
            if (first != null && second != null) {
                value = first.value + second.value;
                first = first.next;
                second = second.next;
            } else if (first == null) {
                value = second.value;
                second = second.next;
            } else if (second == null) {
                value = first.value;
                first = first.next;
            }
            System.out.println("value: " + value);
            if (value >= 10) {
                value = value + reminder;
                reminder = 1;
                value = value - 10;
            } else {
                value = value + reminder;
                if (value >= 10) {
                    reminder = 1;
                    value = value - 10;
                } else reminder = 0;
            }
            LinkedList c = new LinkedList(value);
            if (newListHead == null) {
                newListHead = c;
                current = c;
            } else {
                current.next = c;
                current = c;
            }
            System.out.println("c: " + current.value);
        }
        if (reminder == 1) {
            current.next = new LinkedList(reminder);
        }
        return newListHead;
    }

    public static void traverse(LinkedList h) {
        if (h == null) return;
        LinkedList c = h;
        while (c != null) {
            System.out.print(c.value + " -> ");
            c = c.next;
        }
        System.out.print("Null");
    }

    public static void main(String args[]) {
        LinkedList ll1 = new LinkedList(1);
        LinkedList ll2 = new LinkedList(1);
        LinkedList ll3 = new LinkedList(1);
        ll1.next = ll2;
        ll2.next = ll3;
        LinkedList ls1 = new LinkedList(9);
        LinkedList ls2 = new LinkedList(9);
        LinkedList ls3 = new LinkedList(9);
        ls1.next = ls2;
        ls2.next = ls3;
        traverse(sumOfLinkedLists(ll1, ls1));
    }
}
