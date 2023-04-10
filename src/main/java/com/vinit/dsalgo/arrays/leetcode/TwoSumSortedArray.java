package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class TwoSumSortedArray {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] indices = new int[2];
        Arrays.fill(indices, -1);
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                indices[0] = i + 1;
                indices[1] = j + 1;
                return indices;
            } else if (sum < target) i++;
            else j--;
        }
        return indices;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
//        int[] nums = {2,3,4};
//        int[] nums = {-1, 0};
//        int[] nums = {5, 25, 75};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
