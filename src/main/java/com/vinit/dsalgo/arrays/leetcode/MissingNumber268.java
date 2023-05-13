package com.vinit.dsalgo.arrays.leetcode;

public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        int total = 0;
        for (int i : nums) total += i;
        return ((nums.length * (nums.length + 1)) / 2) - total;
    }
}
