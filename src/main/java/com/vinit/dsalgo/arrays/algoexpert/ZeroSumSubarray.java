package com.vinit.dsalgo.arrays.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

    public static boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        // brute force
        Set<Integer> set = new HashSet<>();
        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;
            if (i == 0 || currentSum == 0 || !set.add(currentSum)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {-5, -5, 2, 3, -2}; // {1,2,3,4,-10}
        System.out.println(zeroSumSubarray(nums));
    }

}
