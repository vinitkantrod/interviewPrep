package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class MaxProductOfTwoElements {

    public static int maxProduct(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        return ((nums[len - 1] - 1) * (nums[len - 2]-1));
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max1 <= nums[i]) {
                max2 = max1;
                max1 = nums[i];
            }
            if (nums[i] < max1 && nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct(nums));
    }
}
