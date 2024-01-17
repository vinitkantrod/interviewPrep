package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class MissingNumber {

    public static int[] missingNumbers(int[] nums) {
        // Write your code here.
        int n = nums.length + 2;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        for (int i : nums) {
            arr[i] = 1;
        }
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                if (result[0] == 0) result[0] = i;
                else {
                    result[1] = i;
                    return result;
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3};
        System.out.println(Arrays.toString(missingNumbers(nums)));
    }
}
