package com.vinit.dsalgo.trees.leetcode;

import com.vinit.design.problems.elevatorDesign.enums.Status;

import java.util.Stack;

public class ConstructStringFromBinaryTree606 {

    public static String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(4);
        t.right = new TreeNode(3);
        System.out.println(tree2str(t));
    }
}
