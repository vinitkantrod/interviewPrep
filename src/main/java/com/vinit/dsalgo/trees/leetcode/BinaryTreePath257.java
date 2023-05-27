package com.vinit.dsalgo.trees.leetcode;

import com.vinit.design.problems.elevatorDesign.InternalButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePath257 {
    public static List<String> res;
    public static List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }

    public static void dfs(TreeNode root, String s) {
        if(root != null) {
            s += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                res.add(s);
            }
            s += "->";
            dfs(root.left, s);
            dfs(root.right, s);
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        System.out.println(Arrays.asList(binaryTreePaths(t)));
    }
}
