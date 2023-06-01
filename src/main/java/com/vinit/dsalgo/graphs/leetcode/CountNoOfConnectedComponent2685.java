package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class CountNoOfConnectedComponent2685 {

    public static int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < edges.length; i++) {
            int[] e = edges[i];
            if (!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
            if (!map.containsKey(e[1])) map.put(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        System.out.println(map);
        int connectedComponent = 0;
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                visited[node] = true;
                if (set.contains(node)) continue;
                set.add(node);
                 List<Integer> list = map.getOrDefault(node, new ArrayList<>());
                 if (list.size() > 0) {
                     for (int k : list) {
                         queue.add(k);
                     }
                 }
            }
            if (set.size() == 1) {
                connectedComponent++;
                continue;
            }
            System.out.println("set: " + set);
            int edgeCount = 0;
            for (int j = 0; j < edges.length; j++) {
                if (set.contains(edges[j][0])) edgeCount++;
            }
            System.out.println("edgeCount: " + edgeCount);
            if (edgeCount == (set.size() * (set.size() - 1)) / 2) connectedComponent++;
        }
        return connectedComponent;
    }

    public static void main(String[] args) {
        int[][] e = {{0,1},{0,2},{1,2},{3,4}};
//        int[][] e = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        System.out.println(countCompleteComponents(6, e));
    }
}
