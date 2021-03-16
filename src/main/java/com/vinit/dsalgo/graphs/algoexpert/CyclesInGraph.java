package com.vinit.dsalgo.graphs.algoexpert;

public class CyclesInGraph {

    public boolean cycleInGraph(int[][] edges) {
        int numOfNodes = edges.length;
        Boolean[] visited = new Boolean[numOfNodes];
        Boolean[] nodesInStack = new Boolean[numOfNodes];

        for (int i = 0; i < numOfNodes; i++) {
            visited[i] = false;
            nodesInStack[i] = false;
        }

        for (int nodes = 0; nodes < numOfNodes; nodes++) {
            if (visited[nodes]) continue;
            Boolean containsCycle = isNodesInCycle(edges, nodes, visited, nodesInStack);
            if (containsCycle) return true;
        }
        return false;
    }

    public static Boolean isNodesInCycle(int[][] edges, int nodes, Boolean[] visited, Boolean[] nodesInStack) {
        visited[nodes] = true;
        nodesInStack[nodes] = true;
        int[] neighbors = edges[nodes];
        for (int node : neighbors) {
            if (!visited[node]) {
                Boolean containsCycle = isNodesInCycle(edges, node, visited, nodesInStack);
                if (containsCycle) return true;
            } else if (nodesInStack[node]) {
                // this means back edge
                return true;
            }
        }
        nodesInStack[nodes] = false;
        return false;
    }

    public static void main(String args[]) {

    }
}
