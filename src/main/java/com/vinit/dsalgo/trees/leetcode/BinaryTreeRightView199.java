package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class BinaryTreeRightView199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = new TreeNode(1001);
            queue.add(node);
            int val = 1001;
            Queue<TreeNode> levelQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (n.val == 1001) continue;
                val = n.val;
                if (n.left != null) levelQueue.add(n.left);
                if (n.right != null) levelQueue.add(n.right);
            }
            queue.poll();
            queue = levelQueue;
            ans.add(val);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.left = new TreeNode(5);
        t.left.right.left = new TreeNode(100);
        System.out.println(rightSideView(t));
    }
}
