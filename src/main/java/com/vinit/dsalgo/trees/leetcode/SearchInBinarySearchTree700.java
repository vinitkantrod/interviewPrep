package com.vinit.dsalgo.trees.leetcode;

public class SearchInBinarySearchTree700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
