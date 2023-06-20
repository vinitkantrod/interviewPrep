package com.vinit.dsalgo.arrays.leetcode;

public class MinimumOpsToMakeArrayIncreasing1827 {

    public int minOperations(int[] nums) {
        int opsCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) continue;
            int inc = (nums[i - 1] - nums[i] + 1);
            opsCount += inc;
            nums[i] = nums[i] + inc;
        }
        return opsCount;
    }
}
