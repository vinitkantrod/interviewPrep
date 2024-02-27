package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class MaximumSumSubMatrix {

    public static int maximumSumSubmatrix(int[][] matrix, int size) {
        // Write your code here.
        int[][] dp = createMatrix(matrix, size);
//        for (int i = 0; i < matrix.length; i++) System.out.println(Arrays.toString(dp[i]));
        int maxSum = Integer.MIN_VALUE;
        for (int i = size - 1; i < matrix.length; i++) {
            for (int j = size - 1; j < matrix[0].length; j++) {
                int total = dp[i][j];

                Boolean touchTopBorder = (i - size < 0);
                if (!touchTopBorder)
                    total -= dp[i - size][j];
                Boolean touchLeftBorder = (j - size < 0);
                if (!touchLeftBorder)
                    total -= dp[i][j - size];
                Boolean touchTopLeftBorder = (touchLeftBorder || touchTopBorder);
                if (!touchTopLeftBorder)
                    total += dp[i - size][j - size];
                maxSum = Math.max(total, maxSum);
            }
        }
        return maxSum;
    }
    private static int[][] createMatrix(int[][] matrix, int size) {
        int[][] sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) sum[0][i] = sum[0][i - 1] + matrix[0][i];
        for (int i = 1; i < matrix.length; i++) sum[i][0] = sum[i-1][0] + matrix[i][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.println(i + " - " + j);
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{2,4},{5,6},{-3,2}};
        System.out.println(maximumSumSubmatrix(m, 2));
    }
}
