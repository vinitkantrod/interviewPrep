package com.vinit.dsalgo.searching.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

    public static int orangesRotting(int[][] grid) {
        int freshOrangeCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) freshOrangeCount++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty() && freshOrangeCount > 0) {
            Queue<int[]> localQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    int nextRow = point[0] + dirs[i][0];
                    int nextCol = point[1] + dirs[i][1];
                    if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || grid[nextRow][nextCol] != 1) continue;
                    grid[nextRow][nextCol] = 2;
                    freshOrangeCount--;
                    localQueue.add(new int[]{nextRow, nextCol});
                }
            }
            time++;
            queue = localQueue;
        }
        return freshOrangeCount == 0 ? time : -1;
    }
    public static void main(String[] args) {
//        int[][] d = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] d = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(d));
    }
}
