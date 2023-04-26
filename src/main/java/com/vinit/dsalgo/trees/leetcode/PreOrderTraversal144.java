package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreOrderTraversal144 {

    static List<Integer> traversal = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return traversal;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        traversal.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public static void main(String[] args) {
//        TreeNode n = new TreeNode(1);
//        n.right = new TreeNode(2);
//        n.right.left = new TreeNode(3);
        TreeNode n = new TreeNode();
        System.out.println(Arrays.asList(preorderTraversal(n)));
    }
}
