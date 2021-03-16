package com.vinit.dsalgo.linkedlist.algoexpert;

public class ReverseLL {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList reverse(LinkedList head) {
        LinkedList current = head;
        LinkedList nextNode = head.next;
        LinkedList prev = null;
        while (nextNode != null) {
            current.next = prev;
            prev = current;
            current = nextNode;
            nextNode = nextNode.next;
            current.next = prev;
        }
        return current;
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
        LinkedList ll = reverse(l);
        traverse(ll);
    }
}
