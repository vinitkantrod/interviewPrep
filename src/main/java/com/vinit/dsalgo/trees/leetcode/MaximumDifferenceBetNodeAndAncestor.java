package com.vinit.dsalgo.trees.leetcode;

public class MaximumDifferenceBetNodeAndAncestor {

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

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return _maxDiff(root, root.val, root.val);
    }

    public static int _maxDiff(TreeNode node, int curMin, int curMax) {
        if (node == null) return curMax - curMin;
        curMin = Math.min(node.val, curMin);
        curMax = Math.max(node.val, curMax);

        int leftTree = _maxDiff(node.left, curMin, curMax);
        int rightTree = _maxDiff(node.right, curMin, curMax);

        return Math.max(leftTree, rightTree);
    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t13 = new TreeNode(13);
        TreeNode t6 = new TreeNode(6);
        TreeNode t14 = new TreeNode(14);
        TreeNode t3 = new TreeNode(3);
        TreeNode t10 = new TreeNode(10);
        TreeNode t8 = new TreeNode(8);
        t6.left = t4;
        t6.right = t7;
        t3.left = t1;
        t3.right =t6;
        t10.right = t14;
        t14.left = t13;
        t8.left = t3;
        t8.right = t10;
        System.out.println(maxAncestorDiff(t8));
    }
}
