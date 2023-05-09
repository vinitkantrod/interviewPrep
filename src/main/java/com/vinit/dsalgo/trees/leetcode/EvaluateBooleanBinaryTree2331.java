package com.vinit.dsalgo.trees.leetcode;

public class EvaluateBooleanBinaryTree2331 {

    public static boolean evaluateTree(TreeNode root) {
        System.out.println(root.val);
        if (root.val == 0) return false;
        if (root.val == 1) return true;
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(1);
        t.right.left = new TreeNode(0);
        System.out.println(evaluateTree(t));
    }
}
