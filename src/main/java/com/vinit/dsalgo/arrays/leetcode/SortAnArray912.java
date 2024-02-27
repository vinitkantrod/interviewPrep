package com.vinit.dsalgo.arrays.leetcode;

public class SortAnArray912 {

    public static int[] sortArray(int[] nums) {
        int N = nums.length;
        int M = 0;
        for (int i = 0; i < N; i++) M = Math.max(M, nums[i]);
        int[] countArr = new int[M + 1];
        for (int i = 0; i < N; i++) countArr[nums[i]]++;
        for (int i = 1; i <= M; i++) countArr[i] += countArr[i - 1];
        int[] outputArr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            outputArr[countArr[nums[i]] - 1] = nums[i];
            countArr[nums[i]]--;
        }
        return outputArr;
    }
}
