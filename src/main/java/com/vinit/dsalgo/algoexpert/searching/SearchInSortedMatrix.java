package com.vinit.dsalgo.algoexpert.searching;

public class SearchInSortedMatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int j = matrix[0].length - 1;
        int i = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)return new int[]{i,j};
            if (matrix[i][j] < target) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }
}
