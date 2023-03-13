package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class LeftAndRightSumDifferences {

    public static int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] newLeft = new int[n];
        int[] newRight = new int[n];
        for (int idx = 0; idx < n; idx++) {
            if (idx == 0) {
                newLeft[idx] = 0;
                newRight[( n - idx - 1)] = 0;
            } else {
                newLeft[idx] = nums[idx - 1] + newLeft[idx - 1];
                newRight[(n - idx - 1)] = nums[(n - idx)] + newRight[(n - idx)];
            }
        }
        for (int idx = 0; idx < n; idx++) {
            ans[idx] = Math.abs(newLeft[idx] - newRight[(idx)]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRigthDifference(nums)));
    }
}
