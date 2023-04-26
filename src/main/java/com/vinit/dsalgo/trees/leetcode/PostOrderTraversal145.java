package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal145 {

    static List<Integer> traversal = new ArrayList<>();
    public static List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return traversal;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        traversal.add(root.val);
    }
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(n));
    }
}
