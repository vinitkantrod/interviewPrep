package com.vinit.dsalgo.algoexpert.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZeroSumSubArray {

    public static boolean zeroSumSubarray(int[] nums) {
        // O(n^2)
//        for (int left = 0; left < nums.length; left++) {
//            int currSum = 0;
//            for (int right = left; right >= 0; right--) {
//                currSum += nums[right];
//                if (currSum == 0) return true;
//            }
//        }
//        return false;

        // O(n)
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 || set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-5,-5,-2,3,-2};
//        int[] nums = new int[]{6,3,-1,-3,4,-2,2};
        System.out.println(zeroSumSubarray(nums));
    }
}
