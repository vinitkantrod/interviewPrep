package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> booleanMap = new HashMap<>();
        for (int i : nums) {
            if (booleanMap.containsKey(i)) return true;
            booleanMap.put(i, true);
        }
        return false;
    }
}
