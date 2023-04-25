package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class MaxProductDiff1913 {

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length;
        return (nums[m-1] * nums[m - 2]) - (nums[0] * nums[1]);
    }
    public static void main(String[] args) {
        int[] n = {4,2,5,9,7,4,8};
        System.out.println(maxProductDifference(n));
    }
}
