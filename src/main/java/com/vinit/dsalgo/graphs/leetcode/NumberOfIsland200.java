package com.vinit.dsalgo.graphs.leetcode;

import java.util.Arrays;

public class NumberOfIsland200 {

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                    printMatrix(grid);
                }
            }
        }
        return count;
    }

    public static void printMatrix(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[0]));
        }
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != '1') return;
        System.out.println(i + "-" + j + "="+grid[i][j]);
        if (grid[i][j] == '1') grid[i][j] = '2';
        int[] X = {0,0,1,-1};
        int[] Y = {1,-1,0,0};
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + X[k], j + Y[k]);
        }
    }

    public static void main(String[] args) {
        char[][] g = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};
        System.out.println(numIslands(g));
    }
}
