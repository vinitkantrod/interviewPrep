package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] indices = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                indices[0] = i;
                indices[1] = map.get(target - nums[i]);
                return indices;
            } else {
                map.put(nums[i], i);
            }
        }
        return indices;
    }
    public static void main(String[] args[]) {

    }
}
