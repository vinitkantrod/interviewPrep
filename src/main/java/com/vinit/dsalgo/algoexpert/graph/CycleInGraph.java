package com.vinit.dsalgo.algoexpert.graph;

import java.util.Arrays;

public class CycleInGraph {

    public static boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        int numberOfNodes = edges.length;
        Boolean[] visited = new Boolean[numberOfNodes];
        Boolean[] currentlyInStack = new Boolean[numberOfNodes];
        Arrays.fill(visited, false);
        Arrays.fill(currentlyInStack, false);
        for (int nodes = 0; nodes < numberOfNodes; nodes++) {
            if (visited[nodes]) continue;
            Boolean containsCycle = isNodeInCycle(nodes, edges, visited, currentlyInStack);
            if (containsCycle) return true;
        }
        return false;
    }
    private static Boolean isNodeInCycle(int node, int[][] edges, Boolean[] visited, Boolean[] currentlyInStack) {
        visited[node] = true;
        currentlyInStack[node] = true;

        boolean containsCycle = false;
        int[] neighbours = edges[node];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                containsCycle = isNodeInCycle(neighbour, edges, visited, currentlyInStack);
                if (containsCycle) return true;
            } else if (currentlyInStack[neighbour]) return true;
        }
        currentlyInStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
//        int[][] e = new int[][]{{1,3},{2,3,4},{0},{},{2,5},{}};
        int[][] e = new int[][]{{1,2},{2},{}};
        System.out.println(cycleInGraph(e));
    }
}
