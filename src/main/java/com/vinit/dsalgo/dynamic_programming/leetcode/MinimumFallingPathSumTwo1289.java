package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.Arrays;

public class MinimumFallingPathSumTwo1289 {

    public static int getMinPathSum(int[][] grid, int i, int j) {
        if (i >= grid.length) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length && k != j; k++) {
            ans = Math.min(ans, grid[i][k] + getMinPathSum(grid, i + 1, k));
        }
        return ans;
    }
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        if (n == 1) return grid[0][0];
        for (int i = n - 2; i >=0; i--) {
            for (int j = 0; j < n; j++) {
                int min = minValue(grid, i + 1, j, n);
                grid[i][j] += min;
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, grid[0][i]);
        }
        return ans;
    }

    public static int minValue(int[][] grid, int row, int col, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i != col) {
                min = Math.min(min, grid[row][i]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] m = {{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{7,91,61,-46,67}};
        System.out.println(minFallingPathSum(m));
    }
}
