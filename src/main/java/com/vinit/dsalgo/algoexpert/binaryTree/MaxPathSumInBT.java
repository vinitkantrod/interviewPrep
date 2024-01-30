package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSumInBT {

    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        return getMaxSum(tree).get(1);
    }

    public static List<Integer> getMaxSum(BinaryTree node) {
        if (node == null) return new ArrayList<>(Arrays.asList(0, Integer.MIN_VALUE));
        List<Integer> leftMaxSumArr = getMaxSum(node.left);
        Integer leftMaxSumAsABranch = leftMaxSumArr.get(0);
        Integer leftMaxPathSum = leftMaxSumArr.get(1);

        List<Integer> rightMaxSumArr = getMaxSum(node.right);
        Integer rightMaxSumAsABranch = rightMaxSumArr.get(0);
        Integer rightMaxPathSum = rightMaxSumArr.get(1);

        Integer maxChildSumAsaBranch = Math.max(leftMaxSumAsABranch, rightMaxSumAsABranch);
        Integer maxSumAsaBranch = Math.max(maxChildSumAsaBranch + node.value, node.value);
        Integer maxSumAsARootNode = Math.max(
                leftMaxSumAsABranch + node.value + rightMaxSumAsABranch, maxSumAsaBranch);
        int maxSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsARootNode));

        return new ArrayList<>(Arrays.asList(maxSumAsaBranch, maxSum));
    }

    public static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        BinaryTree r = new BinaryTree(1);
//        r.left = new BinaryTree(2);
//        r.right = new BinaryTree(3);
//        r.left.left = new BinaryTree(4);
//        r.left.right = new BinaryTree(5);
//        r.right.left = new BinaryTree(6);
//        r.right.right = new BinaryTree(7);
//        System.out.println(maxPathSum(r));

        BinaryTree r = new BinaryTree(10);
        r.left = new BinaryTree(2);
        r.right = new BinaryTree(10);
        r.left.left = new BinaryTree(20);
        r.left.right = new BinaryTree(1);
        r.right.right = new BinaryTree(-25);
        r.right.right.left = new BinaryTree(3);
        r.right.right.right = new BinaryTree(4);
        System.out.println(maxPathSum(r));
    }
}
