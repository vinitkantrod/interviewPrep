package com.vinit.dsalgo.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowsAndColumnPairs2352 {

    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in map.
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] g = {{1,3,2},{2,7,7}, {2,7,7}};
        System.out.println(equalPairs(g));
    }
}
