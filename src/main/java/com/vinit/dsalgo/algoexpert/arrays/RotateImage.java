package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int i = 0; i < matrix.length; i++) System.out.println(Arrays.toString(matrix[i]));
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int t = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = t;
                left++;
                right--;
            }
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) System.out.println(Arrays.toString(matrix[i]));
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(m);
    }
}
