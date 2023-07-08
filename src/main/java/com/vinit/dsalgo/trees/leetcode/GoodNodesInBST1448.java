package com.vinit.dsalgo.trees.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodNodesInBST1448 {
    static int numGoodNodes = 0;
    public static int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    public static void dfs(TreeNode root, int maxSoFar) {
        if (maxSoFar <= root.val) {
            numGoodNodes++;
        }
        if (root.right != null) {
            dfs(root.right, Math.max(maxSoFar, root.val));
        }
        if (root.left != null) {
            dfs(root.left, Math.max(maxSoFar, root.val));
        }
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(3);
        t.right = new TreeNode(4);
        t.right.right = new TreeNode(5);
        t.right.left = new TreeNode(1);
        System.out.println(goodNodes(t));
    }
}
