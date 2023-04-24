package com.vinit.dsalgo.leetcode75.level1.dp;

public class MinCostClimbingStairs746 {

    public static int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            System.out.println(i + " :: " + (minCost[i - 2] + cost[i - 2]) + " - " + (minCost[i - 1] + cost[i - 1]));
            minCost[i] = Math.min(minCost[i - 2] + cost[i - 2], minCost[i - 1] + cost[i - 1]);
        }

        return minCost[cost.length];
    }

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
