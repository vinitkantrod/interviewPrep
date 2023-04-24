package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.Arrays;

public class UniquePath62 {

    public static int uniquePaths(int m, int n) {
//        int[][] grid = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
//        path(grid, m, n, 0, 0);
        return dp[m - 1][n - 1];
    }

    // Recursive Approach
    public static void path(int[][] grid, int m, int n, int i, int j) {
        if (i >= m || j >= n) return;
//        System.out.println("i: " + i + ", j: " + j);
        if (i == m - 1 && j == n - 1) grid[i][j]++;
        path(grid, m, n, i+1, j);
        path(grid, m, n, i, j + 1);
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
}
