package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class ArraysFromPermutations {

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int idx = 0; idx < nums.length; idx++) {
            ans[idx] = nums[nums[idx]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }

}
