package com.vinit.dsalgo.trees.leetcode;

public class DeleteNodeInBST450 {
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right!= null) root = root.right;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                int val = successor(root);
                root.right = deleteNode(root.right, val);
            } else {
                int val = predecessor(root);
                root.left = deleteNode(root.left, val);
            }
        }
        return root;
    }
}
