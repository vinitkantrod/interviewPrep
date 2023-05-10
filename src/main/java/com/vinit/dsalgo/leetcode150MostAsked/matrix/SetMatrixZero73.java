package com.vinit.dsalgo.leetcode150MostAsked.matrix;

import java.util.Arrays;
import java.util.Set;

public class SetMatrixZero73 {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = -1;
                    setMatrixZero(matrix, i, j, m, n);
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void setMatrixZero(int[][] matrix, int i, int j, int m, int n) {
        System.out.println(i + " - " + j);
        for (int x = 0; x < m; x++) {
            if (matrix[x][j] != -1)
                matrix[x][j] = 0;
        }
        for (int y = 0; y < n; y++) {
            if (matrix[i][y] != -1)
                matrix[i][y] = 0;
        }
    }

    public static void main(String[] args) {
//        int[][] m = {{-1}, {2}, {3}};
        int[][] m = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(m);
    }
}
