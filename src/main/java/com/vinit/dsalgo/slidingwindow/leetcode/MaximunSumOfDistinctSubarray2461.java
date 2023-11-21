package com.vinit.dsalgo.slidingwindow.leetcode;

import java.util.*;

public class MaximunSumOfDistinctSubarray2461 {

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> kSet = new HashSet<>();
        Deque<Integer> data = new ArrayDeque<>();
        int maxSum = 0;
        int tempSum = 0;
        int c = 0;
        while (c < nums.length) {
            if (c < k ) {
                kSet.add(nums[c]);
                data.addLast(nums[c]);
                tempSum += nums[c];
            } else {
                int x = data.getFirst();
                int y = nums[c];
                if (!kSet.contains(y)) {
                    kSet.add(y);
                    kSet.remove(x);
                    data.addLast(y);
                    data.removeFirst();
                    tempSum -= x;
                    tempSum += y;
                    if (tempSum > maxSum) {
                        maxSum = tempSum;
                    }
                }
                System.out.println("kset: " + kSet);
            }
            c++;
            System.out.println("c: " + c + ", tempSum: " + tempSum);
        }
        System.out.println("maxSum: " + maxSum);
        if (tempSum > maxSum) maxSum = tempSum;
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] n = {1,2,3,4,5,6,7,8,9};
        int[] n = {1,1,1};
        System.out.println(maximumSubarraySum(n, 3));
    }
}
