package com.vinit.dsalgo.linkedlist.algoexpert;

public class RemoveDuplicatesFromLL {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        if (linkedList == null || linkedList.next == null) return linkedList;
        LinkedList currentNode = linkedList;
        LinkedList nextNode = linkedList.next;
        while (nextNode != null) {
            System.out.println("C: " + currentNode.value + ", N: " + nextNode.value);
            if (currentNode.value == nextNode.value) {
//                next = nextNode.next;
                currentNode.next = nextNode.next;
                nextNode.next = null;
                nextNode = currentNode.next;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return linkedList;
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
        LinkedList l = new LinkedList(1);
        LinkedList l1 = new LinkedList(1);
        LinkedList l2 = new LinkedList(3);
        LinkedList l3 = new LinkedList(4);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(4);
        LinkedList l6 = new LinkedList(5);
        LinkedList l7 = new LinkedList(6);
        LinkedList l8 = new LinkedList(6);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        traverse(removeDuplicatesFromLinkedList(l));
    }
}
