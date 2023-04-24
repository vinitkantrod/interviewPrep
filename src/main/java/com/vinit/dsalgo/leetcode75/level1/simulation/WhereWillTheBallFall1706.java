package com.vinit.dsalgo.leetcode75.level1.simulation;

import java.util.Arrays;

public class WhereWillTheBallFall1706 {

    public static int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            System.out.println("Validating For col: " + i);
            res[i] = getOpenColSlot(grid, i);
            System.out.println(Arrays.toString(res));
//            break;
        }
        return res;
    }

    public static int getOpenColSlot(int[][] grid, int col) {
        int rowStart = 0;
        int rowEnd = grid.length;
        while (rowStart < rowEnd) {
            System.out.println(rowStart + " rowValue: " + grid[rowStart][col]);
            if (grid[rowStart][col] == 1) {
                if (col == grid[0].length-1) return -1; // Right Side wall found
                if (grid[rowStart][col+1] == -1) return -1; // V shape found
                col++;
            } else {
                if (col == 0) return -1;
                if (grid[rowStart][col - 1] == 1) return -1;
                col--;
            }
            if (rowStart == rowEnd) return col;
            System.out.println("new col: " + col);
            rowStart++;
        }
        System.out.println("exit with col: " + col);
        return col;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1}, {1,1,1,-1,-1}, {-1,-1,-1,1,1}, {1,1,1,1,-1}, {-1,-1,-1,-1,-1}};
//        int[][] grid = {{-1}};
//        int[][] grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        System.out.println(findBall(grid));
    }
}
