package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class TwoSumLessThanK1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums); // Time cost O(nlogn).
        int max = -1, i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) { // find one candidate.
                max = Math.max(max, sum);
                ++i; // increase the smaller element.
            }else {
                --j; // decrease the bigger element.
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
