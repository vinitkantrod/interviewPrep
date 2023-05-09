package com.vinit.dsalgo.trees.leetcode;

public class ClosetBinarySearchTreeValue270 {

    double diff = Double.MAX_VALUE;
    int minValue = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return minValue;
        if (root.val == target) {
            minValue = root.val;
            diff = 0;
        } else if (target < root.val) {
            if (Math.abs(root.val - Math.abs(target)) < diff) {
                diff = Math.abs(root.val - Math.abs(target));
                minValue = root.val;
            } else if (Math.abs(root.val - Math.abs(target)) == diff) {
                minValue = Math.min(minValue, root.val);
            }
            closestValue(root.left, target);
        } else {
            if (Math.abs(root.val - Math.abs(target)) < diff) {
                diff = Math.abs(root.val - Math.abs(target));
                minValue = root.val;
            } else if (Math.abs(root.val - Math.abs(target)) == diff) {
                minValue = Math.min(minValue, root.val);
            }
            closestValue(root.right, target);
        }
        return minValue;
    }
}
