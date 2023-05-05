package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfPairs2341 {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        System.out.println(map);
        int pairCount = 0;
        int leftoverCount = 0;
        for (Map.Entry m : map.entrySet()) {
            int val = (int)m.getValue();
            if (val % 2 == 0) pairCount += val / 2;
            else {
                int newV = val - 1;
                pairCount += newV / 2;
                leftoverCount++;
            }
        }
        return  new int[]{pairCount, leftoverCount};
    }
}
