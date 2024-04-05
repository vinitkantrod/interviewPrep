package com.vinit.dsalgo.google.assesment;

import java.util.Arrays;

/**
 * Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k, and
 * (r, c) is a valid position in the matrix.
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * Example 2:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 */
public class MatrixSum {

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] copyMatrix = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j< mat[0].length; j++) {
                copyMatrix[i][j] = mat[i][j];
            }
        }
//        System.out.println("==============");
//        for (int i = 0; i < mat.length; i++) {
//            System.out.println(Arrays.toString(copyMatrix[i]));
//        }
//        System.out.println("=============");
        for (int i = 0 ; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int sum = 0;
                for (int x = i - k; x <= i + k; x++) {
                    for (int y = j - k; y <= j + k; y++) {
                        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length) continue;
                        sum += copyMatrix[x][y];
                    }
                }
                mat[i][j] = sum;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] ma = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(matrixBlockSum(ma, 1)));
    }
}
