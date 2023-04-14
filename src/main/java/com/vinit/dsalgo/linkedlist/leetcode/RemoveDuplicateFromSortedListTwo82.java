package com.vinit.dsalgo.linkedlist.leetcode;

public class RemoveDuplicateFromSortedListTwo82 {

    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode prev = null;
//        ListNode current = head;
//        ListNode nextNode = head.next;
//        while (nextNode != null) {
//            if (current.val != nextNode.val) {
//                prev = current;
//                current = nextNode;
//                nextNode = nextNode.next;
//            } else {
//                while (nextNode.val == current.val) {
//                    nextNode = nextNode.next;
//                }
//                if (nextNode == null) {
//                    current.next = null;
//                    prev.next = null; // prev is comings as null here and hence null pointer exc
//                    break;
//                }
//                if (head == null) {
//                    head = nextNode;
//                    nextNode = nextNode.next;
//                } else {
//                    if (prev == null ) prev = nextNode;
//                    else prev.next = nextNode;
//                    head = nextNode;
//                    nextNode = nextNode.next;
//                }
//            }
//        }
//        return head;

        // LC code
        // Create a new LikedList that will contain our final answer in .next
        ListNode newList = new ListNode();
        // Create a copy of the head of the new LinkedList
        ListNode newListHead = newList;

        // Iterate over the list
        while(head != null){
            // Keep track of whether or not we moved over a chunk of duplicated
            boolean wentOverAChunk = false;
            // This while loop jumps over the chunk of duplicated
            while(head.next != null && head.next.val == head.val){
                head = head.next;
                wentOverAChunk = true; // Set to true if we encountered duplicates
            }
            // If we haven't encountered duplicates, add a copy of the node to the newList
            if(!wentOverAChunk){
                newList.next = new ListNode(head.val);
                newList = newList.next;
            }
            head = head.next;
        }
        return newListHead.next;
    }
}
