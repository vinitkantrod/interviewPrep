package com.vinit.dsalgo.searching.algoexpert;

import java.util.Arrays;

public class SearchInSortedMatrix {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if(matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }

    public static void main(String args[]) {
        int[][] n = {{1,4,7,12,15,1000}, {2,5,19,31,32,1001}, {3,8,24,33,35,1002}, {40, 41, 42, 44, 45, 1003}};
        System.out.println(Arrays.toString(searchInSortedMatrix(n, 44)));
    }
}
