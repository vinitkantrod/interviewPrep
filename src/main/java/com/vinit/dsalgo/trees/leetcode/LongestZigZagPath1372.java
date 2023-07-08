package com.vinit.dsalgo.trees.leetcode;

import com.sun.source.tree.Tree;

import java.lang.annotation.Native;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestZigZagPath1372 {
    static Map<TreeNode, Integer[]> map = new HashMap<>();
    static int maxPath = 0;
    public static int longestZigZag(TreeNode root) {
        map.put(root, new Integer[]{0,0});
        Integer[] val = dfs(root);
        return maxPath;
    }
    private static Integer[] dfs(TreeNode root) {
        if (root == null) return new Integer[]{0,0};
        if (root.left == null && root.right == null) {
            map.put(root, new Integer[]{0,0});
        }
        Integer[] val = new Integer[]{0,0};
        if (root.right != null) {
            val[1] = 1 + dfs(root.right)[0];
        }
        if (root.left != null) {
            val[0] = 1 + dfs(root.left)[1];
        }
        maxPath = Math.max(maxPath, Math.max(val[0], val[1]));
        System.out.println(root.val + " - " + Arrays.toString(val));
        return val;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right.right = new TreeNode(5);
        t.right.right.left = new TreeNode(6);
        t.right.right.left.right = new TreeNode(7);
        t.right.right.left.right.right = new TreeNode(8);
        System.out.println(longestZigZag(t));
    }
}
