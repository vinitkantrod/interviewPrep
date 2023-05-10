package com.vinit.dsalgo.graphs.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StarGraph1791 {

    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == edges.length) return m.getKey();
        }
        return 0;
    }
}
