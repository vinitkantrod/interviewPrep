package com.vinit.dsalgo.trees.leetcode;

public class BinaryTreeTilt563 {
    private int totalTilt;
    public int findTilt(TreeNode root) {
        totalTilt = 0;
        dfs(root);
        return totalTilt;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftSum = dfs(root.left);
        int right = dfs(root.right);
        int tilt = Math.abs(leftSum - right);
        totalTilt += tilt;
        return root.val + leftSum + right;
    }
}
