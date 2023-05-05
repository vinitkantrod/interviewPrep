package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalls1742 {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            String s = String.valueOf(i);
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += (c - '0');
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int maxVal = Integer.MIN_VALUE;
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() > maxVal) maxVal = (int) m.getValue();
        }
        return maxVal;
    }
}
