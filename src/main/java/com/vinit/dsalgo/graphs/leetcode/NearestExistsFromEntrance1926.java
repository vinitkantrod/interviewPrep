package com.vinit.dsalgo.graphs.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExistsFromEntrance1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        int startRow = entrance[0];
        int startCol = entrance[1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});
        maze[startRow][startCol] = '+';
        int[][] dirs = new int[][]{{1,0}, {-1, 0},{0,1},{0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            int distance = curr[2];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (0 <= nextRow && nextRow < row && 0 <= nextCol && nextCol < col && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextRow == row - 1 || nextCol == 0 || nextCol == col - 1) {
                        return distance + 1;
                    }
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, distance + 1});
                }
            }
        }
        return -1;

    }
}
