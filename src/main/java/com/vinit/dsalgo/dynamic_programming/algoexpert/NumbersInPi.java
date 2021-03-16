package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumbersInPi {

    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numbersTable = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) numbersTable.add(numbers[i]);
        int minSpace = getMinSpace(numbersTable, pi, new HashMap<Integer, Integer>(), 0);
        return minSpace == Integer.MAX_VALUE ? -1 : minSpace;
    }

    public static int getMinSpace(Set<String> numbersTable, String pi, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) return -1;
        if (cache.containsKey(idx)) return cache.get(idx);
        int minspace = Integer.MAX_VALUE;
        for (int i = 0; i < pi.length(); i++) {
            String prefix = pi.substring(idx, i + 1);
            if (numbersTable.contains(prefix)) {
                int minSpaceSuffix = getMinSpace(numbersTable, pi, cache, idx);
                if (minSpaceSuffix == Integer.MAX_VALUE) {
                    minspace = Math.min(minspace, minSpaceSuffix);
                } else {
                    minspace = Math.min(minspace, minSpaceSuffix + 1);
                }
            }
        }
        cache.put(idx, minspace);
        return cache.get(idx);
    }
}
