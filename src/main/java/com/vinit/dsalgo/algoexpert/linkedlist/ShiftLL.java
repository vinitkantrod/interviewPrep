package com.vinit.dsalgo.algoexpert.linkedlist;

public class ShiftLL {

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        if (k == 0) return head;
        int l = 1;
        LinkedList listTail = head;
        while (listTail.next != null) {
            l++;
            listTail = listTail.next;
        }
        int offset = Math.abs(k) % l;
        if (offset == 0) return head;
        int newTailPos = k > 0 ? l - offset : offset;
        LinkedList newTail = head;
        for (int i = 1; i < newTailPos; i++) {
            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;
        return newHead;
    }

    protected static int getLen(LinkedList head) {
        LinkedList curr = head;
        int count = 1;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void printLL(LinkedList h) {
        LinkedList c = h;
        while (c != null) {
            System.out.print(c.value + " -> ");
            c = c.next;
        }
        System.out.println("null");
    }
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList n1 = new LinkedList(1);
        LinkedList n2 = new LinkedList(2);
        LinkedList n3 = new LinkedList(3);
        LinkedList n4 = new LinkedList(4);
        LinkedList n5 = new LinkedList(5);
        LinkedList n6 = new LinkedList(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        printLL(n1);
        printLL(shiftLinkedList(n1, 8));
    }
}
