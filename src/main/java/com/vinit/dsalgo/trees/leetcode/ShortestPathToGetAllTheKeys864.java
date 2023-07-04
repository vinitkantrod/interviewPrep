package com.vinit.dsalgo.trees.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestPathToGetAllTheKeys864 {
    int minPath;
    public int shortestPathAllKeys(String[] grid) {
        minPath = 0;
        int keyCount = 0;
        char[][] matrix = new char[grid.length][grid[0].length()];
        int[] startingPoint = {-1, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c  = grid[i].charAt(j);
                matrix[i][j] = c;
                if (Character.isLowerCase(c)) keyCount++;
                if (c == '@') {
                    startingPoint[0] = i;
                    startingPoint[1] = j;
                }
            }
        }
        dfs(matrix, startingPoint[0], startingPoint[1],
                new HashMap<String, Boolean>(),
                new HashSet<String>(),
                0) ;
        return minPath;
    }

    public void dfs(char[][] matrix, int i, int j,
                    Map<String, Boolean> visited,
                    Set<String> keySet,
                    int minimumPathCount
    ) {
        if (i < 0 ||
                i >= matrix.length ||
                j < 0 ||
                j >= matrix[0].length) return;
        if (matrix[i][j] == '#') return;
        String s = i + "_" + j;
        if (visited.containsKey(s)) return;
        if (Character.isUpperCase(matrix[i][j]) &&
                !keySet.contains(Character.toLowerCase(matrix[i][j]))) return;
        if (Character.isLowerCase(matrix[i][j])) keySet.add(s);
        int[] X = {0,0,-1,1};
        int[] Y = {-1,1,0,0};
        for (int x = 0; x <= 3; x++) {
            dfs(matrix, i + X[x], j + Y[x], visited, keySet, minimumPathCount);
        }
    }

}
