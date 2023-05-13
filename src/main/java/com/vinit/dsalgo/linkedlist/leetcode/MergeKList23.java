package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.*;

public class MergeKList23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        List<Integer> numList = new ArrayList<>();
        for (ListNode l : lists) {
            ListNode currHead = l;
            while (currHead != null) {
                numList.add(currHead.val);
                currHead = currHead.next;
            }
        }
        Collections.sort(numList);
        System.out.println(numList);
        ListNode curr = dummy;
        for (int i : numList) {
            ListNode temp = new ListNode(i);
            curr.next = temp;
            if (dummy.next == null) dummy.next = curr;
            curr = curr.next;
        }
        return dummy.next;

//        Queue<List<Object>> queue = new PriorityQueue<>();
//        ListNode dummy = new ListNode(0);
//        ListNode head = dummy;
//        for (ListNode l : lists) {
//            List<Object> lst = new ArrayList<>();
//            lst.add(l.val);
//            lst.add(l);
//            queue.add(lst);
//        }
//
//        while (!queue.isEmpty()) {
//            List<Object> lst = queue.poll();
//            int val = (int)lst.get(0);
//            ListNode node = (ListNode) lst.get(1);
//            head = new ListNode(val);
//            node = node.next;
//            if (node != null) {
//                List<Object> ll = new ArrayList<>();
//                ll.add(node.val);
//                ll.add(node);
//                queue.add(ll);
//            }
//        }
//        return dummy.next;
    }
}
