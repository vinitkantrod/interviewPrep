package com.vinit.dsalgo.queue.leetcode;

import java.util.LinkedList;

public class LongestContinousSubArrayWithAbsDiffLessThanLimit1438 {

    public static int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1) return 1;
        int len = 1;
        int MaxLen = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            System.out.println("next num: " + num);
            System.out.println(queue);
//            int count = 1;
            if (!queue.isEmpty()) {
                int peek = queue.peek();
                System.out.println("peek: " + peek);
                if (Math.abs(num - peek) > limit) {
                    queue.poll();
                    len--;
                    // check if repeated nums exists
                    if (!queue.isEmpty()) {
                        int tempPeek = queue.poll();
                        while (tempPeek == peek) {
                            queue.poll();
                            len--;
                            tempPeek = !queue.isEmpty() ? queue.peek() : -1;
                        }
                    }
                }
            }
            queue.add(num);
            len++;
            System.out.println("len: " + len);
            if (MaxLen < len) MaxLen = len;

        }
        return MaxLen;
    }

    public static void main(String[] args) {
//        int[] n = {8,2,4,7}; // 4
//        int[] n = {10,1,2,4,7,2}; // 5
        int[] n = {4,2,2,2,4,4,2,2}; // 0
        System.out.println(longestSubarray(n, 0));
    }
}
