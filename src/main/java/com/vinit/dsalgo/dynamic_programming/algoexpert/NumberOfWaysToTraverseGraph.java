package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;

public class NumberOfWaysToTraverseGraph {

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        int[][] graph = new int[height][width];
        for (int i = 0; i < height; i++) graph[i][0] = 1;
        Arrays.fill(graph[0], 1 );
        for (int i = 1; i < height; i++) for (int j = 1; j < width; j++) graph[i][j] = graph[i-1][j] + graph[i][j - 1];
        return graph[height - 1][width -1];
    }

    public static void main(String args[]) {
        numberOfWaysToTraverseGraph(3, 4);
    }
}
