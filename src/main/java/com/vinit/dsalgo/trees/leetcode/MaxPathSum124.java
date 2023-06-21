package com.vinit.dsalgo.trees.leetcode;

public class MaxPathSum124 {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromTree(root);
        return maxSum;
    }

    private int gainFromTree(TreeNode root) {
        if (root == null) return 0;
        int gainFromLeftSubTree = Math.max(gainFromTree(root.left), 0);
        int gainFromRightSubTree = Math.max(gainFromTree(root.right), 0);
        maxSum = Math.max(maxSum, gainFromRightSubTree + gainFromLeftSubTree + root.val);
        return Math.max(gainFromLeftSubTree + root.val, gainFromRightSubTree + root.val);
    }
}
