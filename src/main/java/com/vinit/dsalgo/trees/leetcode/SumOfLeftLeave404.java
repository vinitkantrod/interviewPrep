package com.vinit.dsalgo.trees.leetcode;

public class SumOfLeftLeave404 {

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
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        return dfs(root, 0, false);
    }

    public static int dfs(TreeNode root, int sum, Boolean isLeft) {
        if (root == null) return sum;
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return sum;
        }
        int left = dfs(root.left, sum, true);
        int right = dfs(root.right, sum, false);
        return left + right;
    }

    public static void main(String[] args) {
//        TreeNode t = new TreeNode(3);
//        t.left = new TreeNode(9);
//        t.right = new TreeNode(20);
//        t.left.left = new TreeNode(15);
//        t.left.right = new TreeNode(7);
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(t));
    }
}
