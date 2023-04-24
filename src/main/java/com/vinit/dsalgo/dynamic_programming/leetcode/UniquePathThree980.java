package com.vinit.dsalgo.dynamic_programming.leetcode;

public class UniquePathThree980 {

    static int m, n;
    static int count = 0;
    static int res = 0;
    static int[] X = {0,0,1,-1};
    static int[] Y = {1,-1,0,0};
    public static int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    rec(grid, i, j, 0);
                }
            }
        }
        return res;
    }

    public static void rec(int[][] grid, int x, int y, int step) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (grid[x][y] == 2) {
            if (step == count + 1) res++;
            return;
        }
        if (grid[x][y] == -1 || grid[x][y] == 2 || grid[x][y] == 3) return;

        grid[x][y] = 3;

        for (int l = 0; l < 4; l++) {
            rec(grid, X[l] + x, Y[l] + y, step + 1);
        }
        grid[x][y] = 0;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePathsIII(grid));
    }
}
