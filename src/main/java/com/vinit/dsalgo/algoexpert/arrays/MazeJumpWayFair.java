package com.vinit.dsalgo.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MazeJumpWayFair {

    public static int minJumpMaze(List<List<Integer>> maze, int k) {
        int mLen = maze.size();
        int nLen = maze.get(0).size();
        int[][] result = new int[maze.size()][maze.get(0).size()];
        for (int i = 0; i < result.length; i++) Arrays.fill(result[i], Integer.MAX_VALUE);
        result[0][0] = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        while (!queue.isEmpty()) {
            int[] n = queue.remove();
            if (n[0] < 0 || n[1] < 0 || n[0] >= mLen || n[1] >= nLen) continue;
            if (maze.get(n[0]).get(n[1]) == 1) continue;
            if (result[n[0]][n[1]] != -1 && result[n[0]][n[1]] < n[2]) continue;

            System.out.println("node: " + Arrays.toString(n));

            result[n[0]][n[1]] = Math.min(n[2], result[n[0]][n[1]]);
            for (int m = 1; m <= k; m++) {
                queue.add(new int[]{n[0], n[1] + m, n[2] + 1});
            }
            // vertical down
            for (int m = 1; m <= k; m++) {
                queue.add(new int[]{n[0] + m, n[1], n[2] + 1});
            }
            // horizontal left
            for (int m = 1; m <= k; m++) {
                queue.add(new int[]{n[0], n[1] - m, n[2] + 1});
            }
            // vertical up
            for (int m = 1; m <= k; m++) {
                queue.add(new int[]{n[0] - m, n[1], n[2] + 1});
            }
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(Arrays.toString(queue.get(i)));
            }
            System.out.println("================");
        }
        return result[mLen - 1][nLen - 1] == Integer.MAX_VALUE ? -1 : result[mLen - 1][nLen - 1];
    }

    public static void main(String[] args) {
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(List.of(0,0,0,0));
        lst.add(List.of(1,1,1,0));
        for (int i = 0; i < lst.size(); i++) System.out.println(List.of(lst.get(i)));
        System.out.println(minJumpMaze(lst, 2));
    }
}
