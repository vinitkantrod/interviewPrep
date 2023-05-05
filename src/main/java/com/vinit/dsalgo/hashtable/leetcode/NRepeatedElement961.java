package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElement961 {

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int bigValue = 0;
        int bigkey = -1;
        for (Map.Entry m : map.entrySet()) {
            int v = (int) m.getValue();
            if (v > bigValue) {
                bigValue = v;
                bigkey = (int) m.getKey();
            }
        }
        return bigkey;
    }
}
