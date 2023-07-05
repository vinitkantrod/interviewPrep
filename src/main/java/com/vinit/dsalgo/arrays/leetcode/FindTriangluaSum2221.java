package com.vinit.dsalgo.arrays.leetcode;

public class FindTriangluaSum2221 {

    public static int triangularSum(int[] nums) {
        while (nums.length != 1) {
            int[] newNum = new int[nums.length - 1];
            for (int k = 0; k < nums.length - 1; k++) {
                newNum[k] = (nums[k] + nums[k + 1]) % 10;
            }
            nums = newNum;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] n= {1,2,3,4,5};
        System.out.println(triangularSum(n));
    }
}
