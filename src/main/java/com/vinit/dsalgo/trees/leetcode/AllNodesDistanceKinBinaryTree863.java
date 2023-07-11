package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree863 {

    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;
    List<Integer> answer;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        answer = new ArrayList<>();
        buildGraph(root, null);
        visited.add(target.val);
        dfs(target.val, 0, k);
        return answer;
    }
    private void buildGraph(TreeNode root, TreeNode parent) {
        if (root != null || parent != null) {
            graph.computeIfAbsent(root.val, k-> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k-> new ArrayList<>()).add(root.val);
        }
        if (root.left != null) {
            buildGraph(root.left, root);
        }
        if (root.right != null) {
            buildGraph(root.right, root);
        }
    }
    private void dfs(int val, int distance, int k) {
        if (distance == k) {
            answer.add(val);
            return;
        }
        for (Integer neighbour : graph.getOrDefault(val, new ArrayList<>()) ) {
            visited.add(neighbour);
            dfs(neighbour, distance + 1, k);
        }
    }
}
