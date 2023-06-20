package com.vinit.dsalgo.trees.leetcode;

public class MinimumAbsoluteDifferenceBST530 {
//    int minDiff = Integer.MAX_VALUE;
//    public int getMinimumDifference(TreeNode root) {
//        dfs(root);
//        return minDiff;
//    }
//    public void dfs(TreeNode root) {
//        if (root == null) return;
//        if (root.left == null && root.right == null) return;
//        if (root.left != null) {
//            minDiff = Math.min(minDiff, Math.abs(root.val - root.left.val));
//            dfs(root.left);
//        }
//        if (root.right != null) {
//            minDiff = Math.min(minDiff, Math.abs(root.val - root.right.val));
//            dfs(root.right);
//        }
//    }
    private Integer prev;
    private int minDiff;
    public int getMinimumDifference(TreeNode root)
    {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }
    private void inorderTraversal(TreeNode node)
    {
        if (node == null) return;
        inorderTraversal(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorderTraversal(node.right);
    }
}
