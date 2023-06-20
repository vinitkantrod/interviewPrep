package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class VerticalOrderTraversal987 {
    public static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap;
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        treeMap = new TreeMap<>();
        dfs(root, 0, 0);
        printMap();
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> tq : treeMap.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : tq.values()) {
                while (!pq.isEmpty()) {
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }
        return result;
    }
    public static void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        if (!treeMap.containsKey(col)) {
            treeMap.put(col, new TreeMap<>());
        }
        if (!treeMap.get(col).containsKey(row)) {
            treeMap.get(col).put(row, new PriorityQueue<>());
        }
        treeMap.get(col).get(row).offer(root.val);
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

    public static void printMap() {
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> oq : treeMap.entrySet()) {
            System.out.println("Col:" + oq.getKey());
            for (Map.Entry<Integer, PriorityQueue<Integer>> tm : oq.getValue().entrySet()) {
                System.out.print("\tRow: " + tm.getKey());
                System.out.println(" Values: " + tm.getValue());
            }
        }
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(2);
        t.right.left = new TreeNode(2);
        System.out.println(Arrays.asList(verticalTraversal(t)));
    }
}
