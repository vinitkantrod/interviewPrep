/**
 * Link: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
 */
package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;

public class NumberOfPairsWithDifferences {

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i] - k)) {
                count += hashMap.get(nums[i] - k);
            }
            if (hashMap.containsKey(nums[i] + k)) {
                count += hashMap.get(nums[i] + k);
            }
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        return count;
//        for (int i =0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (Math.abs(nums[i] - nums[j]) == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int k = 1;
        System.out.println(countKDifference(nums, k));
    }
}
