package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class VerticalOrderTraversal {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int v) {
            data = v;
        }
    }

    public static void verticalOrder(TreeNode root) {
        int xAxis = 0;
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        createTree(root, xAxis, treeMap);
        for (Map.Entry<Integer, List<Integer>> m : treeMap.entrySet()) {
            System.out.println(m.getKey() + " - " + Arrays.asList(m.getValue()));
        }
    }

    private static void createTree(TreeNode node, int xAxis, Map<Integer, List<Integer>> treeMap) {
        if (node == null) return;
        List<Integer> levelVal = treeMap.getOrDefault(xAxis, new ArrayList<>());
        levelVal.add(node.data);
        treeMap.put(xAxis, levelVal);
        createTree(node.left, xAxis - 1, treeMap);
        createTree(node.right, xAxis + 1, treeMap);

    }
    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);
        verticalOrder(r);
    }
}
