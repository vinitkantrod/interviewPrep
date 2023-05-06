package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo2154 {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        while (set.contains(original)) {
            original = original * 2;
        }
        return original;
    }
}
