package com.vinit.dsalgo.leetcode75.level1.linked_list;

import java.util.List;

public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode mergedHead = null;
        if (list1.val < list2.val) {
            mergedHead = list1;
            list1 = list1.next;
        } else {
            mergedHead = list2;
            list2 = list2.next;
        }
        ListNode tail = mergedHead;
        while (list1 != null && list2 != null) {
            ListNode tempNode = null;
            if (list1.val < list2.val) {
                tempNode = list1;
                list1 = list1.next;
            } else {
                tempNode = list2;
                list2 = list2.next;
            }
            tail.next = tempNode;
            tail = tempNode;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return mergedHead;
    }

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }

    public static ListNode constructList(int[] arr) {
        ListNode head = null;
        ListNode tail = null;
        for (int i : arr) {
            ListNode newNode = new ListNode(i, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,4};
        int[] arr2 = {1,2,5};
        ListNode list1 = constructList(arr1);
        ListNode list2 = constructList(arr2);
        printLL(list1);
        printLL(list2);
        mergeTwoLists(list1, list2);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
 }
