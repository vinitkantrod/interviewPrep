package com.vinit.dp.maxmin;

import java.util.Arrays;

public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        for (int i = 0; i < rows; i++) dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        int maxSqLen = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    System.out.println(i + " - " + j);
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    System.out.println("dp: " + dp[i][j]);
                    print(dp);
                    if (dp[i][j] > maxSqLen) maxSqLen = dp[i][j];
                    System.out.println("max: " + maxSqLen);
                }
            }
        }
        return maxSqLen * maxSqLen;
    }

    private static void print(int[][] m ) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) {
        char[][] i = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(i));
    }
}
