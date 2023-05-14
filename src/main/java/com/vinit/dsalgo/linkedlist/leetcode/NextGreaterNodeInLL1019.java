package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNodeInLL1019 {

    public static int[] nextLargerNodes(ListNode head) {;
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        int[] res = new int[n];
        System.out.println(Arrays.toString(res));
        Stack<Integer[]> stack = new Stack<>();
        int idx = 0;
        stack.push(new Integer[]{head.val, idx++});
        curr = head.next;
        while (curr != null) {
            while (!stack.empty() && stack.peek()[0] < curr.val) {
                int num = stack.pop()[1];
                res[num] = curr.val;
            }
            stack.push(new Integer[]{curr.val, idx++});
            curr = curr.next;
            System.out.println(Arrays.toString(res));
        }
        return res;
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
        int[] n = {2,1,5};
        ListNode l = constructLL(n);
        nextLargerNodes(l);
    }
}
