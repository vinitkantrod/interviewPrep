package com.vinit.dsalgo.trees.leetcode;

public class MaximumDepthOfBT104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        System.out.println(maxDepth(p));
    }
}
