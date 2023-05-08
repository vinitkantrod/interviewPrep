package com.vinit.dsalgo.arrays.leetcode;

public class MaxConsecutiveOnes485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesLength = 0;
        int oneL = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneL++;
                maxOnesLength = Math.max(oneL, maxOnesLength);
            } else oneL = 0;

        }
        return maxOnesLength;
    }
}
