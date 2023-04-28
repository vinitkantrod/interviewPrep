package com.vinit.dsalgo.trees.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList114 {

    static List<TreeNode> res = new LinkedList<>();
    public static void flatten(TreeNode root) {
        dfs(root);
        root = null;
        TreeNode current = null;
        for (int i = 0; i < res.size(); i++) {
            if (current == null) {
                root = res.get(i);
                root.right = null;
                root.left = null;
                current = root;
            } else {
                current.right = res.get(i);
                current = current.right;
                current.right = null;
            }
        }
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        res.add(root);
        dfs(root.left);
        dfs(root.right);
    }
    public static void main(String[] args) {

    }
}
