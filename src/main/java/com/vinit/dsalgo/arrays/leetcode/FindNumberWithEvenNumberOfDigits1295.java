package com.vinit.dsalgo.arrays.leetcode;

public class FindNumberWithEvenNumberOfDigits1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int tempCount = 0;
            while (k > 0) {
                k = k / 10;
                tempCount++;
            }
            if (tempCount % 2 == 0) count++;
        }
        return count;
    }
}
