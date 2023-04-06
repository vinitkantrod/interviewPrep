package com.vinit.dsalgo.arrays.leetcode;

public class DiffBetweenElementSumAndDigitSum {

    public static int differenceOfSum(int[] nums) {
//        int elementSum = Integer.MIN_VALUE;
//        int digitSum = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            elementSum += nums[i];
//            String s = String.valueOf(nums[i]);
//            for (char ch : s.toCharArray()) {
//                digitSum += (ch - '0');
//            }
//        }
//        return Math.abs(elementSum - digitSum);
        int elementSum = Integer.MIN_VALUE;
        int digitSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            elementSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0) {
                int k = nums[i] % 10;
                digitSum += k;
                nums[i] = nums[i] / 10;
            }
        }
        return Math.abs(elementSum - digitSum);
    }
    public static void main(String[] args) {
        int[] res = {1,15,6,3};
        System.out.println(differenceOfSum(res));
    }
}
