package com.vinit.dsalgo.leetcode75.level1.prefix_sum;

import java.util.Arrays;

public class RunningSumOf1DArray {

    public static int[] runningSum(int[] nums) {
        // O(n) SC
//        int[] runningSum = new int[nums.length];
//        runningSum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            runningSum[i] = runningSum[i - 1] + nums[i];
//        }
//        return runningSum;
        // O(1) SC
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i] + nums[i + 1];
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}
