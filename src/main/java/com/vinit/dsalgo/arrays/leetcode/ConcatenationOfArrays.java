package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class ConcatenationOfArrays {

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int idx = 0; idx < nums.length; idx++) {
            ans[idx] = nums[idx];
            ans[idx + nums.length] = nums[idx];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }

}
