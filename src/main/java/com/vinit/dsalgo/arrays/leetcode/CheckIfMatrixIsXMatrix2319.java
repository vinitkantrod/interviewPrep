package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfMatrixIsXMatrix2319 {

    public static boolean checkXMatrix(int[][] grid) {
        Set<String> stringSet = new HashSet<>();
        int n = grid.length;
        // forward diagonal
        int x = 0;
        int y = 0;
        while (x < n && y < n) {
            String key = String.valueOf(x) + ":" + String.valueOf(y);
            if (grid[x][y] == 0) return false;
            stringSet.add(key);
            x++;
            y++;
        }
        x = 0;
        y = n - 1;
        while (x < n && y >= 0) {
            String key = String.valueOf(x) + ":" + String.valueOf(y);
            if (grid[x][y] == 0) return false;
            if (!stringSet.contains(key)) {
                stringSet.add(key);
            }
            x++;
            y--;
        }
//        System.out.println(stringSet);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String key = String.valueOf(i) + ":" + String.valueOf(j);
                if (!stringSet.contains(key) && grid[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] m = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(checkXMatrix(m));
    }
}
