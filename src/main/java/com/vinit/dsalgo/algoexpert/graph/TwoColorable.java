package com.vinit.dsalgo.algoexpert.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoColorable {

    public boolean twoColorable(int[][] edges) {
        // Write your code here.
        int[] color = new int[edges.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        color[0] = 1;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int edge : edges[node] ) {
                if (color[edge] == 0) {
                    color[edge] = color[node] == 1 ? 2 : 1;
                    stack.push(edge);
                } else if (color[edge] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
