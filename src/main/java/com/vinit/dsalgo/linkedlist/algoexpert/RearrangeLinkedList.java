package com.vinit.dsalgo.linkedlist.algoexpert;

public class RearrangeLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {

        LinkedList low = new LinkedList(-1);
        LinkedList lowHead = low;
        LinkedList high = new LinkedList(-1);
        LinkedList curr = head;
        LinkedList secondHead = high;
        while (head != null) {
            if (head.value < k) {
                low.next = new LinkedList(head.value);
                low = low.next;
            } else {
                high.next = new LinkedList(head.value);
                high = high.next;
            }
            head = head.next;
        }
        low.next = secondHead.next;
        printLL(lowHead.next);
        return lowHead.next;
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

    public static void printLL(LinkedList node) {
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }

    public static LinkedList constructLL(int[] arr) {
        LinkedList dummy = new LinkedList(0);
        LinkedList t = dummy;
        for (int i : arr) {
            LinkedList l = new LinkedList(i);
            t.next = l;
            t = l;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] n = {1,2,4,3,1,5,2,7};
        LinkedList l = constructLL(n);
        printLL(l);
        System.out.println(rearrangeLinkedList(l, 3));
    }
}
