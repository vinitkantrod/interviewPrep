package com.vinit.dsalgo.algoexpert.linkedlist;

public class RemoveDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        if (linkedList == null || linkedList.next == null) return linkedList;
        LinkedList currNode = linkedList;
        LinkedList nextNode = linkedList.next;
        while (nextNode != null) {
            if (currNode.value == nextNode.value) {
                currNode.next = nextNode.next;
                nextNode.next = null;
                nextNode = currNode.next;
            } else {
                currNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return linkedList;
    }


}
