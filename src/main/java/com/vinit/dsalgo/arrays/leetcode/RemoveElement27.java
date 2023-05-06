package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class RemoveElement27 {

    public static int removeElement(int[] nums, int val) {
        // TC: O(N) || SC: O(1)
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {2,3,3,2};
        System.out.println(removeElement(nums, 2));
    }
}
