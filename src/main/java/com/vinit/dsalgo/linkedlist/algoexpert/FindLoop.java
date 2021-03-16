package com.vinit.dsalgo.linkedlist.algoexpert;

public class FindLoop {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head.next;
        LinkedList second = head.next.next;
        while (first != second) {
            System.out.println("f: " + first.value + ", s: " + second.value);
            first = first.next;
            second = second.next.next;
        }
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        System.out.println("f: " + first.value);
        System.out.println("s: " + second.value);
        return first;
    }

    public static void main(String args[]) {
        LinkedList l = new LinkedList(0);
        LinkedList l1 = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(5);
        LinkedList l6 = new LinkedList(6);
        LinkedList l7 = new LinkedList(7);
        LinkedList l8 = new LinkedList(8);
        LinkedList l9 = new LinkedList(9);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l4;
        findLoop(l);
    }
}
