package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElement1748 {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int sum = 0;
        for (Map.Entry m : map.entrySet()) {
            int v = (int) m.getValue();
            int k = (int) m.getKey();
            if (v == 1) sum += k;
        }
        return sum;
    }
}
