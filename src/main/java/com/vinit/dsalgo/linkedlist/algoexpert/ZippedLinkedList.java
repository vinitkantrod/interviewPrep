package com.vinit.dsalgo.linkedlist.algoexpert;

import com.vinit.dsalgo.linkedlist.leetcode.ListNode;

public class ZippedLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList zipLinkedList(LinkedList linkedList) {
        // Write your code here.
        if (linkedList == null) return null;
        if (linkedList.next == null) return linkedList;
        LinkedList h1 = linkedList;
        LinkedList h2 = null;
        // Split LL
        LinkedList slow = linkedList;
        LinkedList fast = linkedList;
        LinkedList prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            h2 = prev.next;
            prev.next = null;
        }
        else {
            h2 =  slow.next;
            slow.next = null;
        }
        h2 = reverse(h2);
        printLL(h1);
        printLL(h2);
        LinkedList dummy = new LinkedList(-1);
        LinkedList newHead = new LinkedList(h1.value);
        dummy.next = newHead;
        h1 = h1.next;
        Boolean addH2 = true;
        while (h1 != null && newHead != null) {
            System.out.println(newHead.value);
            if (addH2) {
                newHead.next = new LinkedList(h2.value);
                h2 = h2.next;
                addH2 = false;
            } else {
                newHead.next = new LinkedList(h1.value);
                h1 = h1.next;
                addH2 = true;
            }
            newHead = newHead.next;
        }
        if (h2 != null) newHead.next = new LinkedList(h2.value);
        printLL(dummy.next);
        return dummy.next;
    }

    public static LinkedList reverse(LinkedList head) {
        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
        int[] n = {1,2,3,4,5,6,7};
        LinkedList l = constructLL(n);
        printLL(l);
        System.out.println(zipLinkedList(l));
    }
}
