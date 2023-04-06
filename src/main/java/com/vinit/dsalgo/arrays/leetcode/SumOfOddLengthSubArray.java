/**
 * Link: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
package com.vinit.dsalgo.arrays.leetcode;

public class SumOfOddLengthSubArray {

    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (((i + 1) * (arr.length - i) + 1) / 2) * arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }
}
