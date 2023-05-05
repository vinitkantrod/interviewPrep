package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnoqueNumberOfOccurance1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry m : map.entrySet()) {
            if (set.contains( (int) m.getValue() )) return false;
            else set.add( (int) m.getValue());
        }
        return true;
    }
}
