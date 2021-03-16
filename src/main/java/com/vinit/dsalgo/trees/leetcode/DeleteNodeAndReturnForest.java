package com.vinit.dsalgo.trees.leetcode;

import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;

public class DeleteNodeAndReturnForest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int i = 0; i < to_delete.length; i++) {
            mp.put(to_delete[i], true);
        }
        List<TreeNode> res = new ArrayList<>();
        if (treePurning(root, res, mp) != null) res.add(root);
        return res;
    }

    public static Boolean deleteNode(int val, Map<Integer, Boolean> mp) {
        return mp.containsKey(val);
    }
    public static TreeNode treePurning(TreeNode node, List<TreeNode> res, Map<Integer, Boolean> mp) {
        if (node == null) return null;
        node.left = treePurning(node.left, res, mp);
        node.right = treePurning(node.right, res, mp);
        if (deleteNode(node.val, mp)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }

    public static void main(String args[]) {

    }
}
