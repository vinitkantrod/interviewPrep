package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class DetonateTheMaximumBomb2101 {

    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];
                if ((long)ri * ri >= (long)(xi - xj)*(xi - xj) + (long)(yi - yj)*(yi - yj)) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), map);
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static int dfs(int curr, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        visited.add(curr);
        int count = 1;
        for (int neighbour : map.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(neighbour)) {
                count += dfs(neighbour, visited, map);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] b = {{1,2,3},{2,3,1},{3,4,2}, {4,5,3}, {5,6,4}};
        System.out.println(maximumDetonation(b));
    }
}
