package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn740 {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);
        for (int i = 2; i < maxNumber + 1; i++) {
            int gain = points.getOrDefault(i, 0);
            maxPoints[i] = Math.max(maxPoints[i - 1], maxPoints[i - 2] + gain);
        }
        return maxPoints[maxNumber];
    }
}
