package com.vinit.dsalgo.trees.leetcode;

public class MergeBinaryTree617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode newRoot = null;
        return null;
    }

    public TreeNode mTree(TreeNode node1, TreeNode node2, TreeNode newNode) {
        if (node1 == null && node2 != null) return node2;
        if (node1 != null && node2 == null) return node1;
        return null;
    }
}
