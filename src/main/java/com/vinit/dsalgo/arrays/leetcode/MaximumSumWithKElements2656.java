package com.vinit.dsalgo.arrays.leetcode;

public class MaximumSumWithKElements2656 {

    public int maximizeSum(int[] nums, int k) {
        int maxSum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i : nums) {
            maxNum = Math.max(i, maxNum);
        }
        while (k > 0) {
            maxSum += maxNum;
            maxNum++;
            k--;
        }
        return maxSum;
    }
}
