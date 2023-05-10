package com.vinit.dsalgo.leetcode75.level1.binary_tree;

public class DiameterOfABinaryTree543 {

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

  static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longest(root);
        return diameter;
    }

    public static int longest(TreeNode root) {
        if (root == null) return 0;
        int left = longest(root.left);
        int right = longest(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(2);
//        t.right = new TreeNode(3);
//        t.left.right = new TreeNode(5);
//        t.left.left = new TreeNode(4);
        System.out.println(diameterOfBinaryTree(t));
    }
}
