package com.vinit.dsalgo.trees.leetcode;

public class PathSum112 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return pathSum(root, 0, targetSum);
    }

    public static Boolean pathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) return true;
            else return false;
        }
        return pathSum(root.left, sum, targetSum) || pathSum(root.right, sum, targetSum);
    }
    public static void main(String[] args) {
        TreeNode n= new TreeNode(5);
        n.left = new TreeNode(4);
        n.left.left = new TreeNode(11);
        n.left.left.left = new TreeNode(7);
        n.left.left.right = new TreeNode(2);
        n.right = new TreeNode(8);
        n.right.left = new TreeNode(13);
        n.right.right = new TreeNode(4);
        n.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(n, 22));
    }
}
