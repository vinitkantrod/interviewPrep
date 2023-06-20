package com.vinit.dsalgo.arrays.leetcode;

public class CountEqualAndDivisiblePair2176 {
    public int countPairs(int[] nums, int k) {
        int pair = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    pair++;
                }
            }
        }
        return pair;
    }
}
