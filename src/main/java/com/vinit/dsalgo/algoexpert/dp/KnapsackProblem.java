package com.vinit.dsalgo.algoexpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

    public static List<List<Integer>> knapsackProblem(
            int[][] items, int capacity
    ) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        int[][] dp = new int[items.length + 1][capacity + 1];
        for (int i = 0; i < items.length + 1; i++) dp[i][0] = 0;
        Arrays.fill(dp[0], 0);
        for (int i = 1; i < items.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                int weight = items[i - 1][1];
                int value = items[i - 1][0];
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], value + dp[i - 1][j - weight]);
            }
        }
        int j = capacity;
        int i = items.length;
        result.get(0).add(dp[items.length][capacity]);
        while (i > 0 && j > 0){
            int cap = dp[i][j];
            if (cap != dp[i - 1][j]) {
                result.get(1).add(0, i - 1);
                j = j - items[i - 1][1];
            }
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] i = new int[][]{{1,2},{4,3},{5,6},{6,7}};
        System.out.println(knapsackProblem(i, 10));
    }
}
