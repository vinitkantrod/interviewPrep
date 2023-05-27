package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumRootToLeafNode129 {

    public static int res;
    public static int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, "");
        return res;
    }

    protected static void  dfs(TreeNode root, String s) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                s += Integer.toString(root.val);
                res += Integer.parseInt(s);
            }
            s += Integer.toString(root.val) + "";
            dfs(root.left, s);
            dfs(root.right, s);
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        System.out.println(Arrays.asList(sumNumbers(t)));
    }
}
