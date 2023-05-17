package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class NumberOfConnectedComponents323 {

    public static int countComponents(int n, int[][] edges) {
        int connectedComponent = 0;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            System.out.println(i + " - " + visited[i]);
            if (visited[i]) continue;
            connectedComponent++;
            System.out.println("i: " + i + ", connected: " + connectedComponent);
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                System.out.println("peek: " + queue.peek());
                Integer node = queue.peek();
                queue.poll();
                visited[node] = true;
                for (int neighbour : adjacencyList.get(node)) {
                    if (visited[neighbour]) {
                        continue;
                    }
                    queue.add(neighbour);
                    adjacencyList.get(neighbour).remove(node);
                }
            }
        }
        return connectedComponent;
    }

    public static void main(String[] args) {
        int[][] n = {{0,1}, {1,2}, {3,4}};
        System.out.println(countComponents(5, n));
    }
}
