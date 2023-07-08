package com.vinit.dsalgo.slidingwindow.leetcode;

public class LongestSubArrayOfOnesAfterDeletingOneElement1493 {

    public int longestSubarray(int[] nums) {
        int start = 0;
        int longestWindow = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += nums[i] == 0 ? 1 : 0;
            while (zeroCount > 1) {
                zeroCount -= nums[start] == 0 ? 1 : 0;
                start++;
            }

            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }
}
