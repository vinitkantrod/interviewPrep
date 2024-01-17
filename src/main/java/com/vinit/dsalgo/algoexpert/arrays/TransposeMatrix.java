package com.vinit.dsalgo.algoexpert.arrays;

public class TransposeMatrix {

    public int[][] transposeMatrix(int[][] matrix) {
        // Write your code here.
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
