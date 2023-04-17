package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LonelyNodes1469 {
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right != null){
            res.add(root.right.val);
        }
        if (root.left != null && root.right == null){
            res.add(root.left.val);
        }
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(4);
//        TreeNode n4 = new TreeNode(3);
//        n1.left = n2;
//        n1.right = n4;
//        n2.right = n3;

        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(2);
        n4.left = n5;
        n4.right = n6;
        n6.right = n7;
        getLonelyNodes(n1);
    }
}
