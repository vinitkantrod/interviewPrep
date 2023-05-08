package com.vinit.dsalgo.arrays.leetcode;

public class MaxConsecutivesOnesTwo487 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int prevZeroIdx = -1;
        int maxCount = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                start = prevZeroIdx + 1;
                prevZeroIdx = end;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] n = {1,0,1,1,0};
        System.out.println(findMaxConsecutiveOnes(n));
    }
}
