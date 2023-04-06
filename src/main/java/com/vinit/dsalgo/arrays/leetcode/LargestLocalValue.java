package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class LargestLocalValue {

    public static int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid[0].length-2][grid[0].length-2];
        int max;
        for (int i = 0; i < grid[0].length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                max = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (grid[x][y] > max) {
                            max = grid[x][y];
                        }
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] grid = {{9,9,8,1}, {5,6,2,6}, {8,2,6,4},{6,2,2,2}};
        System.out.println(Arrays.asList(largestLocal(grid)));
    }
}
