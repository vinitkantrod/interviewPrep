package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SameTree100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        TreeNode n2 = new TreeNode(3);
        n2.left = new TreeNode(9);
        n2.right = new TreeNode(20);
        n2.right.left = new TreeNode(15);
        n2.right.right = new TreeNode(7);
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(1);
        System.out.println(isSameTree(p, q));
    }
}
