package com.vinit.dsalgo.arrays.leetcode;

public class ClosestNumberToZero2239 {

    public static int findClosestNumber(int[] nums) {
        int closestNumber = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - 0) == minDiff) {
                if (nums[i] > closestNumber) closestNumber = nums[i];
                continue;
            }
            if (Math.abs(nums[i] - 0) < minDiff) {
                minDiff = Math.abs(nums[i] - 0);
                closestNumber = nums[i];
            }
        }
        return closestNumber;
    }
    public static void main(String[] args) {
//        int[] n = {-4,-2,1,-1,4,8};
//        int[] n = {-4,-2};
//        int[] n = {1,-1,0};
        int[] n = {1,-2,-3};
        System.out.println(findClosestNumber(n));
    }
}
