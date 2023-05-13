package com.vinit.dsalgo.linkedlist.leetcode;

public class SwappingNodesInTheLinkedList1721 {

    public static ListNode swapNodes(ListNode head, int k) {

//        ListNode dummy= new ListNode(0);
//        dummy.next = head;
//        ListNode firstNode = head;
//        int tempCount = k;
//        while ( tempCount > 1) {
//            firstNode = firstNode.next;
//            tempCount--;
//        }
//        System.out.println(firstNode.val);
//        ListNode curr = firstNode;
//        ListNode secondNode = head;
//        while (curr.next != null) {
//            curr = curr.next;
//            secondNode = secondNode.next;
//        }
//        System.out.println(secondNode.val);
//        Integer temp = firstNode.val;
//        firstNode.val = secondNode.val;
//        secondNode.val = temp;
//        printLL(head);
//        return head;

        // Single pass
        int listLength = 0;
        ListNode frontNode = null;
        ListNode endNode = null;
        ListNode currentNode = head;
        // set the front node and end node in single pass
        while (currentNode != null) {
            listLength++;
            if (endNode != null)
                endNode = endNode.next;
            // check if we have reached kth node
            if (listLength == k) {
                frontNode = currentNode;
                endNode = head;
            }
            currentNode = currentNode.next;
        }
        // swap the values of front node and end node
        int temp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = temp;
        return head;
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

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5};
//        int[] n = {7,9,6,6,7,8,3,0,9,5};
        ListNode l = constructLL(n);
        printLL(l);
        System.out.println(swapNodes(l, 2));
    }
}
