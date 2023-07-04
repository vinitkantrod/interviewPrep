package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.Arrays;

public class MinimumFallingPathSum931 {

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            dp[0][i] = new int[]{matrix[0][i], matrix[0][i]};
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = getMinimum(i, j, dp, matrix);
//                System.out.println("i: " + i + ", j: " + j + " = " + Arrays.toString(dp[i][j]));
            }
        }
        // Print DP matrix
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(Arrays.toString(dp[i][j]));
//            }
//            System.out.println();
//        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minValue = Math.min(dp[n - 1][i][1], minValue);
        }
        return minValue;
    }
    public static int[] getMinimum(int i, int j, int[][][] dp, int[][] matrix) {
        int[] J = {-1,0,1};
        int minPathSum = Integer.MAX_VALUE;
        for (int k : J) {
            if ((j + k) < 0 || (j + k) >= matrix.length) continue;
            minPathSum = Math.min(minPathSum, matrix[i][j] + dp[i-1][j + k][1]);
        }
        return new int[]{matrix[i][j], minPathSum};
    }
    public static void main(String[] args) {
        int[][] m = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(m));
    }
}
