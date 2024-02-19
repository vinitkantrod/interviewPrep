package com.vinit.dsalgo.algoexpert.graph;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    ans.add(dfs(i, j, matrix));
                }
            }
        }
        return ans;
    }

    private static int dfs(int i, int j, int[][] matrix) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0)
            return 0;
        int count = 1;
        matrix[i][j] = 0;
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            count += dfs(x, y, matrix);
        }
        return count;
    }
}
