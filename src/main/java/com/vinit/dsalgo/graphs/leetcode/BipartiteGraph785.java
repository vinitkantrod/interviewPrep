package com.vinit.dsalgo.graphs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BipartiteGraph785 {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                color[start] = 0;
                while (!stack.empty()) {
                    int node = stack.pop();
                    for (int no : graph[node]) {
                        if (color[no] == -1) {
                            stack.push(no);
                            color[no] = color[node] ^ 1;
                        } else if (color[no] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
