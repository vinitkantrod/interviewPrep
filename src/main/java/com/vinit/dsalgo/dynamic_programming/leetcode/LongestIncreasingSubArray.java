package com.vinit.dsalgo.dynamic_programming.leetcode;

public class LongestIncreasingSubArray {

    public static int lengthOfLIS(int[] nums) {
        int i = 1;
        int maxLen = 0;
        while ( i < nums.length) {
            int incr = 1;
            System.out.println("num: " + nums[i]);
            while ((i + incr) < nums.length && nums[(i + incr)] > nums[(i + incr) - 1] ) {
                incr++;
            }
            System.out.println("range till: " + incr);
            i = (i + incr);
            System.out.println("new I: " + i);
            maxLen = Math.max(maxLen, incr);
            System.out.println("maxLen: " + maxLen);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] n = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(n));
    }
}
