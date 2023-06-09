package com.vinit.dsalgo.arrays.leetcode;

public class DiffBetweenElementSumAndDigitSum2535 {

    public int differenceOfSum(int[] nums) {
        int digitSum = 0;
        int elementSum = 0;
        for (int i = 0; i < nums.length; i++) {
            elementSum += nums[i];
            int k = nums[i];
            while (k > 0) {
                digitSum += k % 10;
                k = k / 10;
            }
        }
        return Math.abs(elementSum - digitSum);
    }
}
