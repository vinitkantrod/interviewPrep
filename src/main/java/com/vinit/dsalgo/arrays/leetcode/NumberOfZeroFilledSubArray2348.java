package com.vinit.dsalgo.arrays.leetcode;

public class NumberOfZeroFilledSubArray2348 {

    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[] {1,3,0,0,0,2,0,0,6,0}));
        System.out.println(zeroFilledSubarray(new int[] {1}));
        System.out.println(zeroFilledSubarray(new int[] {0}));
        System.out.println(zeroFilledSubarray(new int[] {0, 0}));
        System.out.println(zeroFilledSubarray(new int[] {0, 0,0}));
        System.out.println(zeroFilledSubarray(new int[] {0, 0, 0, 0}));
        System.out.println(zeroFilledSubarray(new int[] {0, 0, 1, 0, 0}));
        System.out.println(zeroFilledSubarray(new int[] {0, 0, 0, 2, 0, 0}));
        System.out.println(zeroFilledSubarray(new int[] {10, 10}));
    }
}
