package com.vinit.dsalgo.slidingwindow.leetcode;

import java.util.Arrays;

//Sliding Window Pattern
// https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/1175088/C++-Maximum-Sliding-Window-Cheatsheet-Template/
public class FrequencyOfMostFrequentElement1838 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, N = nums.length, ans = 1, sum = 0;
        for (int j = 0; j < N; j++) {
            sum += nums[j];
            if ((j - i + 1) * nums[j] - sum > k) sum -= nums[i++];
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
