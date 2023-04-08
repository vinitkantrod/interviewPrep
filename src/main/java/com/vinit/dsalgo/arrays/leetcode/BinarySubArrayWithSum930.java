package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithSum930 {

    // Similiar to Leetcode (LC) problem no 560
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == goal) result++;
            if (map.containsKey(sum - goal)) {
                result += map.get(sum - goal);
            }
            map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
        }
        return result;
    }
}
