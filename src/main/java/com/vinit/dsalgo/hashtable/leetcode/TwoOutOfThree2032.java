package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class TwoOutOfThree2032 {

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
                set.add(nums1[i]);
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!set.contains(nums2[i])) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
                set.add(nums2[i]);
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < nums3.length; i++) {
            if (!set.contains(nums3[i])) {
                map.put(nums3[i], map.getOrDefault(nums3[i], 0) + 1);
                set.add(nums3[i]);
            }
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() >= 2) list.add((int) m.getKey());
        }

        return list;
    }
}
