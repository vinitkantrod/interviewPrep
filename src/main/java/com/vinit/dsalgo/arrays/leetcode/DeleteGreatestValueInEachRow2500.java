package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DeleteGreatestValueInEachRow2500 {

    public static int deleteGreatestValue(int[][] grid) {
        int maxSum = 0;
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            for (int j = 0; j < grid[0].length / 2; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i][grid[0].length - 1 - j];
                grid[i][grid[0].length - 1 - j] = temp;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        while (k < grid[0].length) {
            int localMax = Integer.MIN_VALUE;
            for (int i = 0; i < grid.length; i++) {
                if (localMax < grid[i][k]) localMax = grid[i][k];
            }
            maxSum += localMax;
            k++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,4},{3,3,1}};
        System.out.println(deleteGreatestValue(grid));
    }
}
