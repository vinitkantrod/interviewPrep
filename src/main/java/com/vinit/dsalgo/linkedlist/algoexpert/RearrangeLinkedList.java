package com.vinit.dsalgo.linkedlist.algoexpert;

public class RearrangeLinkedList {

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList smallestHead = null;
        LinkedList smallestTail = null;
        LinkedList equalHead = null;
        LinkedList equalTail = null;
        LinkedList greatestHead = null;
        LinkedList greatestTail = null;

        LinkedList node = head;
        while (node != null) {
            if (node.value < k) {
                LinkedListPair smallestPair = growLinkedList(smallestHead, smallestTail, node);
                smallestHead = smallestPair.head;
                smallestTail = smallestPair.tail;
                System.out.println("SH: " + smallestHead.value + ", ST: " + smallestTail.value);
            } else if (node.value > k) {
                LinkedListPair greatestPair = growLinkedList(greatestHead, greatestTail, node);
                greatestHead = greatestPair.head;
                greatestTail = greatestPair.tail;
                System.out.println("GH: " + greatestHead.value + ", GT: " + greatestTail.value);
            } else {
                LinkedListPair equalPair = growLinkedList(equalHead, equalTail, node);
                equalHead = equalPair.head;
                equalTail = equalPair.tail;
                System.out.println("EH: " + equalHead.value + ", ET: " + equalTail.value);
            }
            LinkedList prevNode = node;
            node = node.next;
            prevNode.next = null;
        }

        LinkedListPair firstPair = connectLinkedList(smallestHead, smallestTail, equalHead, equalTail);
        LinkedListPair finalPair = connectLinkedList(firstPair.head, firstPair.tail, greatestHead, greatestTail);
        return finalPair.head;
    }

    public static LinkedListPair  connectLinkedList(LinkedList headOne, LinkedList tailOne, LinkedList headTwo, LinkedList tailTwo) {
        LinkedList newHead = headOne != null ? headOne : headTwo;
        LinkedList newTail = tailTwo == null ? tailOne : tailTwo;
        if (tailOne != null) tailOne.next = headTwo;
        return new LinkedListPair(newHead, newTail);
    }

    public static LinkedListPair growLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head;
        LinkedList newTail = node;

        if (newHead == null) newHead = node;
        if (tail != null) tail.next = null;

        return new LinkedListPair(newHead, newTail);
    }

    public static class LinkedListPair {
        public LinkedList head;
        public LinkedList tail;
        public LinkedListPair(LinkedList head, LinkedList tail) {
            this.head= head;
            this.tail = tail;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
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
        LinkedList l = new LinkedList(3);
        LinkedList l1 = new LinkedList(0);
        LinkedList l2 = new LinkedList(5);
        LinkedList l3 = new LinkedList(2);
        LinkedList l4 = new LinkedList(1);
        LinkedList l5 = new LinkedList(4);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        LinkedList ll = rearrangeLinkedList(l, 3);
        traverse(ll);
    }
}
