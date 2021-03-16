package com.vinit.dsalgo.linkedlist.algoexpert;

public class ShiftLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int len = 1;
        LinkedList tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        int offset = Math.abs(k) % len;
        if (offset == 0) return head;
        int newTailPos = k > 0 ? len - offset : offset;
        LinkedList newTail = head;
        for (int i = 1; i < newTailPos; i++) {
            newTail = newTail.next;
        }
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }

    public static LinkedList shiftForward(LinkedList head, int k) {
        LinkedList current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        LinkedList kthNode = current;

        while (current.next != null) {
            current= current.next;
        }
        current.next = head;

        head = kthNode.next;
        kthNode.next = null;
        return head;
    }

    public static LinkedList shiftBackward(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList second = head;
        int count = 0;
        while (count < k && second != null) {
            second = second.next;
            count++;
        }
        if (second == null) {
            return head;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        LinkedList kthNode = first;
        while (first.next != null) {
            first = first.next;
        }
        first.next = head;
        head = kthNode.next;
        kthNode.next = null;
        return head;
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
        LinkedList ll = shiftLinkedList(l, 2);
        traverse(ll);
    }
}
