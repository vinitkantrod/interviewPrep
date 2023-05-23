package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;
import java.util.Map;

public class LeftAndRightSumDifference2574 {

    public int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
//        int[] right = new int[nums.length];
        left[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftSum;
            leftSum += nums[i];
        }
        System.out.println(Arrays.toString(left));
        for (int i = nums.length - 1; i >= 0; i--) {
            left[i] = Math.abs(left[i] - rightSum);
            rightSum += nums[i];
        }
        System.out.println(Arrays.toString(left));
        return left;
    }
}
