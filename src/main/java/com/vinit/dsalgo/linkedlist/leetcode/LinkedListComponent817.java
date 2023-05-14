package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponent817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        int connectedComponent = 0;
        Boolean checkComponent = false;
        while (curr != null) {
            if (set.contains(curr.val)) {
                if (!checkComponent) {
                    checkComponent = true;
                    connectedComponent++;
                }
            } else {
                checkComponent = false;
            }
            curr = curr.next;
        }
        return connectedComponent;
    }
}
