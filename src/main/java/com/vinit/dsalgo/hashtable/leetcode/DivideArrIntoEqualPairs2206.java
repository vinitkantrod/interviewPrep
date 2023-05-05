package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DivideArrIntoEqualPairs2206 {

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() % 2 != 0) return false;
        }
        return true;
    }
}
