package com.vinit.dsalgo.leetcode75.level1.binary_tree;

import com.vinit.dsalgo.trees.leetcode.MaximumDifferenceBetNodeAndAncestor;
import com.vinit.dsalgo.trees.leetcode.TreeNode;

public class InvertBinaryTree226 {

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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode newRoot = new TreeNode(root.val);
        invert(root, newRoot);
        return newRoot;
    }

    public static void invert(TreeNode root, TreeNode newNode) {
        if (root == null || (root.left == null && root.right == null)) return;
        System.out.println(root.left.val + " - " + root.right.val);
        if (root.left  != null) {
            newNode.right = new TreeNode(root.left.val);
            System.out.println( root.val +" root.left: " + root.left.val);
            invert(root.left, newNode.right);
        }
        if (root.right != null) {
            newNode.left = new TreeNode(root.right.val);
            System.out.println(root.val + " root.right: " + root.right.val);
            invert(root.right, newNode.left);
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.right = new TreeNode(7);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(9);
        System.out.println(invertTree(t));
    }
}
