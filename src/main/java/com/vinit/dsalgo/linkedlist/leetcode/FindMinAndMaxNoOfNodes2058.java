package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinAndMaxNoOfNodes2058 {

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int[] res = {-1, -1};
        List<Integer> criticalPoints = new ArrayList<>();
        int x = 1;
        while (curr.next != null) {
            if ( (prev.val < curr.val && curr.val > curr.next.val)
                || (prev.val > curr.val && curr.val < curr.next.val)
            ) {
                criticalPoints.add(x);
            }
            x++;
            prev = curr;
            curr = curr.next;
        }
        System.out.println(Arrays.asList(criticalPoints));
        int minDistance = Integer.MAX_VALUE;
        int startIdx = -1;
        int endIdx = -1;
        if (criticalPoints.size() <= 1) return res;
        for (int i = 0; i < criticalPoints.size(); i++) {
            if (startIdx == -1) startIdx = criticalPoints.get(i);
            if (i > 0) minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }
        endIdx = criticalPoints.get(criticalPoints.size() - 1);
        return new int[]{minDistance, endIdx - startIdx};
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);
        l.next.next.next = new ListNode(1);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(l)));
    }
}
