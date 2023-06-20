package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumOfRectanglesThatCanFormSquare1725 {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int minLen = Math.min(rectangles[i][0], rectangles[i][1]);
            maxLen = Math.max(maxLen, minLen);
            countMap.put(minLen, countMap.getOrDefault(minLen, 0) + 1);
        }
        return countMap.get(maxLen);
    }
}
