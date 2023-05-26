package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class AverageOfLevelsOfBinaryTree637 {

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
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        double d = root.val;
        if (root.left == null && root.right == null) return new ArrayList<>(Arrays.asList(d));
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            int count = 0;
            long sum = 0;
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (n.left != null) tempQueue.add(n.left);
                if (n.right != null) tempQueue.add(n.right);
                sum += n.val;
                count++;
            }
            while (!tempQueue.isEmpty()) {
                queue.add(tempQueue.poll());
            }
            result.add((double) sum / count);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.left.left = new TreeNode(15);
        t.left.right = new TreeNode(7);
        System.out.println(averageOfLevels(t));
    }
}
