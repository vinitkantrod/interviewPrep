package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedLL1836 {

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Set<Integer> allNodesSet = new HashSet<>();
        Set<Integer> duplicateSets = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (allNodesSet.contains(current.val)) {
                duplicateSets.add(current.val);
            } else {
                allNodesSet.add(current.val);
            }
            current = current.next;
        }
        System.out.println(allNodesSet);
        System.out.println(duplicateSets);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        current = dummy;
        while (current != null) {
            ListNode temp = current.next;
            System.out.println("temp: " + temp.val);
            while (temp != null && duplicateSets.contains(temp.val)) {
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
        printLL(dummy.next);
        return dummy.next;
    }

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }

    public static ListNode constructLL(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        for (int i : arr) {
            ListNode l = new ListNode(i);
            t.next = l;
            t = l;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,2,3,1,4,6,4,5};
        ListNode head = constructLL(arr);
        System.out.println(deleteDuplicatesUnsorted(head));
    }
}
