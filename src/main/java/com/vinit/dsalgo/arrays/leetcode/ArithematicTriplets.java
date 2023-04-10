/**
 * Link: https://leetcode.com/problems/number-of-arithmetic-triplets/solutions/
 */
package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArithematicTriplets {
    public static int arithmeticTriplets(int[] nums, int diff) {
//        int tripletCount = 0;
//        for (int i = 0; i < nums.length-2;i++) {
//            for (int j = i+1; j < Math.min(nums.length-1, i + 2 + diff);j++) {
//                if (nums[j] - nums[i] > diff) {
//                    break;
//                }
//                for (int k = j+1; k < Math.min(nums.length, j + 2 + diff);k++) {
////                    System.out.println("Index::i: " + i + ", j: " + j + ", k: " + k);
//                    if (nums[k] - nums[j] > diff) {
//                        break;
//                    }
////                    System.out.println("---i: " + nums[i] + ", j: " + nums[j] + ", k: " + nums[k]);
//                    if (
//                            (nums[k] - nums[j]) == diff &&
//                                    (nums[j] - nums[i]) == diff) {
//                        tripletCount++;
//                    }
//                }
//            }
//
//        }
//        return tripletCount;

        int tripletCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) set.add(nums[i]);
        for (int i = 0; i < nums.length; i++) if (set.contains(nums[i] - diff) && set.contains(nums[i] - (diff * 2))) tripletCount++;
        return tripletCount;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,4,6,7,10};
        int[] nums = {0,1,2,3,4,5,6};
        int diff = 3;
        System.out.println(arithmeticTriplets(nums, diff));
    }
}
