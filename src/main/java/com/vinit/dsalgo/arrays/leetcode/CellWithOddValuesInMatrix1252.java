package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class CellWithOddValuesInMatrix1252 {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], 0);
        }
        for (int i = 0;i<indices.length;i++) {
            int r = indices[i][0];
            int c = indices[i][1];
            for (int x = 0; x < n; x++) {
                matrix[r][x] += 1;
            }
            for (int x = 0; x < m; x++) {
                matrix[x][c] += 1;
            }
        }
        int oddCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] % 2 == 1) oddCount++;
            }
        }
        return oddCount;
    }
}
