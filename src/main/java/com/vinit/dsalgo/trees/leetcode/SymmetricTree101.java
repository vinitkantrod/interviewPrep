package com.vinit.dsalgo.trees.leetcode;

public class SymmetricTree101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return symmetry(root.left, root.right);
    }

    public static Boolean symmetry(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return symmetry(p.left, q.right) && symmetry(p.right, q.left);
    }
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(2);
        n.left.left = new TreeNode(3);
        n.right.right = new TreeNode(4);
        n.left.right = new TreeNode(4);
        n.right.left = new TreeNode(3);
        System.out.println(isSymmetric(n));
    }
}
