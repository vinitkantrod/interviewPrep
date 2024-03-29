package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindAnagamMapping760 {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
