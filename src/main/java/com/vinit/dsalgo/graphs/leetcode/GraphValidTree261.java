package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class GraphValidTree261 {

    public static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                if (parent.get(node) == neighbour) {
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                queue.offer(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == n;
    }

    public static void main(String[] args) {
        int[][] e = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println(validTree(5, e));
    }
}
