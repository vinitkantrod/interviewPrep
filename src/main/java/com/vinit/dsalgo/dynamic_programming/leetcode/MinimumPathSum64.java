package com.vinit.dsalgo.dynamic_programming.leetcode;

public class MinimumPathSum64 {

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i ==0 && j == 0) continue;
                System.out.println(i + " - " + j);
                if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
                else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else {
                    int topSum = i == 0 ? 0 : dp[i - 1][j];
                    int leftSum = j == 0 ? 0 : dp[i][j - 1];
                    System.out.println(topSum + " __ " + leftSum);
                    dp[i][j] = Math.min(topSum, leftSum) + grid[i][j];
                }
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
