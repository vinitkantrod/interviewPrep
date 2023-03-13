package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class ShuffleArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int idx = 0; idx < nums.length / 2; idx++) {
            ans[idx * 2] = nums[idx];
            ans[(idx * 2 + 1)] = nums[idx + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,2,1};
        System.out.println(Arrays.toString(shuffle(nums, nums.length / 2)));
    }
}
