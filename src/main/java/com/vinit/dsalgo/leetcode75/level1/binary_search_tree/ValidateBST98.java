package com.vinit.dsalgo.leetcode75.level1.binary_search_tree;

public class ValidateBST98 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBST(root, min, max);
    }

    public boolean isBST(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return (
                isBST(node.left, min, node.val) &&
                        isBST(node.right, node.val, max)
                );
    }
}
