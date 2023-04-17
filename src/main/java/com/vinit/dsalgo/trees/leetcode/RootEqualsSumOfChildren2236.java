package com.vinit.dsalgo.trees.leetcode;

public class RootEqualsSumOfChildren2236 {

    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val) ? true : false;
    }
}
