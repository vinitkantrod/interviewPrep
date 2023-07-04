package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestAirthSequence1027 {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        return maxLength;
    }
}
