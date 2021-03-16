package com.vinit.dsalgo.linkedlist.algoexpert;

public class MergeLL {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }


    private static LinkedList mergeLL(LinkedList headOne, LinkedList headTwo) {
        if (headOne == null) return headTwo;
        if (headTwo == null) return headOne;
        if (headOne.value < headTwo.value) {
            headOne.next = mergeLL(headOne.next, headTwo);
            return headOne;
        } else {
            headTwo.next = mergeLL(headOne, headTwo.next);
            return headTwo;
        }
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
        LinkedList ll1 = new LinkedList(2);
        LinkedList ll2 = new LinkedList(6);
        LinkedList ll3 = new LinkedList(7);
        LinkedList ll4 = new LinkedList(8);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        LinkedList ls1 = new LinkedList(1);
        LinkedList ls2 = new LinkedList(3);
        LinkedList ls3 = new LinkedList(4);
        LinkedList ls4 = new LinkedList(5);
        LinkedList ls5 = new LinkedList(9);
        LinkedList ls6 = new LinkedList(10);
        ls1.next = ls2;
        ls2.next = ls3;
        ls3.next = ls4;
        ls4.next = ls5;
        ls5.next = ls6;

        LinkedList ll = mergeLL(ll1, ls1);
        traverse(ll);
    }
}
