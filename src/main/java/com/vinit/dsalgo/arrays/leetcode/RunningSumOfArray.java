package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class RunningSumOfArray {

    public static int[] runningSum(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        for (int idx = 1; idx < nums.length; idx++) {
            nums[idx] = nums[idx-1] + nums[idx];
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}
