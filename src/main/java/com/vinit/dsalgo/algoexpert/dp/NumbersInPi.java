package com.vinit.dsalgo.algoexpert.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumbersInPi {

    public static int numbersInPi(String pi, String[] numbers) {
        // Write your code here.
        Set<String> numberSet = new HashSet<>();
        for (String s : numbers) numberSet.add(s);
        int[] result = new int[pi.length() + 1];
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpace = calculateSpace(pi, numberSet, cache, 0);
        return minSpace == Integer.MAX_VALUE ? -1 : minSpace;
    }
    private static int calculateSpace(String pi, Set<String> numberSet, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) return -1;
        if (cache.containsKey(idx)) return cache.get(idx);
        int minSpace = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String sub = pi.substring(idx, i + 1);
            if (numberSet.contains(sub)) {
                int minSpaceSuffix = calculateSpace(pi, numberSet, cache, i + 1);
                if (minSpaceSuffix == Integer.MAX_VALUE) minSpace = Math.min(minSpace, minSpaceSuffix);
                else minSpace = Math.min(minSpace, minSpaceSuffix + 1);
            }
        }
        cache.put(idx, minSpace);
        return cache.get(idx);
    }
}
