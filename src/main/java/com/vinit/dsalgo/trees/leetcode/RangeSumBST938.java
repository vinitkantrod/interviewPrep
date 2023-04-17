package com.vinit.dsalgo.trees.leetcode;

public class RangeSumBST938 {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        return rangeSum(root, low, high, sum);
    }

    public static int rangeSum(TreeNode root, int low, int high, int sum) {
        if (root == null) return 0;
        System.out.println("Sum: " + sum + ", val: " + root.val);
        sum += (rangeSum(root.left, low, high, sum) + rangeSum(root.right, low, high, sum));
        if (root.val >= low && root.val <= high) {
//            System.out.println("before: " + root.val + " - " + sum);
            sum += root.val;
//            System.out.println("after: " + root.val + " - " + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        n1.left = new TreeNode(5);
        n1.right = new TreeNode(15);
        n1.left.left = new TreeNode(3);
        n1.left.right = new TreeNode(7);
        n1.right.right = new TreeNode(18);
        n1.right.left = null;
        System.out.println(rangeSumBST(n1, 7, 15));
    }
}
