package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int maxCount = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int x = i;
                count = 1;
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
