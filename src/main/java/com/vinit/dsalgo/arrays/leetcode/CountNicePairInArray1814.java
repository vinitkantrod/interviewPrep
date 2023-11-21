package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CountNicePairInArray1814 {

    public static int countNicePairs(int[] nums) {
        long result = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - rev(nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            long count = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
            result = (result % mod + (count * (count - 1) ) / 2) % mod;
        }
        return  (int) result % mod;
//        Map<Integer, Integer> reverseMap = new HashMap<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            int a = nums[i];
//            int revNumA = rev(a);
//            if (!reverseMap.containsKey(a)) reverseMap.put(a, revNumA);
//            for (int j = i + 1; j < nums.length; j++) {
//                int b = nums[j];
//                int revNumB = rev(b);
//                if (!reverseMap.containsKey(b)) reverseMap.put(b, revNumB);
//                if ((a + revNumB) == (b + revNumA)) {
//                    System.out.println(a + " - " + b);
//                    result++;
//                }
//            }
//        }
//        return result;
    }

    public static int rev(int x) {
        int revNum = 0;
        while (x > 0) {
            revNum = (revNum * 10) + (x % 10);
            x /= 10;
        }
        return revNum;
    }
    public static void main(String[] args) {
//        int[] nums = {42,11,1,97};
        int[] nums = {13,10,35,24,76};
        System.out.println(countNicePairs(nums));
    }
}
