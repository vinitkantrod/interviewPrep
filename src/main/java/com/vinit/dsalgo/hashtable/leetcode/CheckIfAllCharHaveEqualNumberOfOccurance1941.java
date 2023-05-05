package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckIfAllCharHaveEqualNumberOfOccurance1941 {

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length();i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int val = -1;
        for (Map.Entry m : map.entrySet()) {
            int v = (int) m.getValue();
            if (val == -1 ) val = v;
            else if (v != val) return false;
        }
        return true;
    }
}
