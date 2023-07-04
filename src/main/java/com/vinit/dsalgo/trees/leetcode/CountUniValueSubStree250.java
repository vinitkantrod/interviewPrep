package com.vinit.dsalgo.trees.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountUniValueSubStree250 {
    static Map<TreeNode, Set<Integer>> nodeMap;
    static int subTreeCount;
    public static int countUnivalSubtrees(TreeNode root) {
        subTreeCount = 0;
        nodeMap = new HashMap<>();
        traverse(root);
        return subTreeCount;
    }
    public static void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        traverse(root.right);
        Set<Integer> rootSet = new HashSet<>();
        rootSet.add(root.val);
        if (nodeMap.containsKey(root.left)) rootSet.addAll(nodeMap.get(root.left));
        if (nodeMap.containsKey(root.right)) rootSet.addAll(nodeMap.get(root.right));
        if (rootSet.size() == 1) subTreeCount++;
//        System.out.println("Root: " + root.val + ", val: " + rootSet);
        nodeMap.put(root, rootSet);
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(5);
        t.left.right = new TreeNode(5);
        t.right = new TreeNode(5);
        t.right.right = new TreeNode(4);
        System.out.println(countUnivalSubtrees(t));
    }
}
