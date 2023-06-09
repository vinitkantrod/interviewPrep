package com.vinit.dsalgo.arrays.leetcode;

public class LargestLocalValueInMatrix2373 {

    public int[][] largestLocal(int[][] grid) {
        int[][] matrix = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                matrix[i][j] = getMaxLocal(grid, i, j);
            }
        }
        return matrix;
    }

    public int getMaxLocal(int[][] grid, int i, int j) {
//        return Math.max(grid[i][j],
//                Math.max(grid[i][j + 1],
//                        Math.max(grid[i][j + 2],
//                                Math.max(grid[i+ 1][j],
//                                        Math.max(grid[i+1][j + 1],
//                                                Math.max(grid[i + 1][j + 2],
//                                                        Math.max(grid[i + 2][j],
//                                                                Math.max(grid[i + 2][j + 1], grid[i + 2][j + 2]))))))));
        int max = Integer.MIN_VALUE;
        for (int a = i; a < i+3; a++) {
            for (int b = j; b < j+3; b++) {
                max = Math.max(grid[a][b], max);
            }
        }
        return max;
    }

}
