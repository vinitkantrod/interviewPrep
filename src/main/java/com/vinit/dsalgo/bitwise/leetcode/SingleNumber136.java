package com.vinit.dsalgo.bitwise.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {
//        int sumOfSet = 0, sumOfNums = 0;
//        Set<Integer> set = new HashSet<>();
//
//        for (int num : nums) {
//            if (!set.contains(num)) {
//                set.add(num);
//                sumOfSet += num;
//            }
//            sumOfNums += num;
//        }
//        return 2 * sumOfSet - sumOfNums;
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
