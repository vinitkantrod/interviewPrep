package com.vinit.dsalgo.algoexpert.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfWaysToTraverse {
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) matrix[i][0] = 1;
        for (int i = 0; i < width; i++) matrix[0][i] = 1;
        print(matrix);
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
            print(matrix);
        }
        return matrix[height - 1][width - 1];
    }
    private static void print(int[][] m ) {
        System.out.println("====");
        for (int i = 0; i < m.length;i++) System.out.println(Arrays.toString(m[i]));
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(2,3));
    }
}
