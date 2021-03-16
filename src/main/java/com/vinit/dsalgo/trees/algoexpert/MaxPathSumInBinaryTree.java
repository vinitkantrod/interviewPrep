package com.vinit.dsalgo.trees.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSumInBinaryTree {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static List<Integer> findMaxSum(BinaryTree tree) {
        List<Integer> newMaxPathSum = new ArrayList<>();
        if (tree == null) {
            newMaxPathSum.add(0);
            newMaxPathSum.add(Integer.MIN_VALUE);
            return newMaxPathSum;
        }
        List<Integer> leftBranchSUm = findMaxSum(tree.left);
        List<Integer> rightBranchSUm = findMaxSum(tree.right);

        int maxChildSum = Math.max(leftBranchSUm.get(0), rightBranchSUm.get(0));
        int maxSumAsBranch = Math.max(maxChildSum + tree.value, tree.value);
        int maxSumAsRoot = Math.max(maxSumAsBranch, leftBranchSUm.get(0) + tree.value + rightBranchSUm.get(0));
        int maxPathSum = Math.max(maxSumAsRoot, Math.max(leftBranchSUm.get(1), rightBranchSUm.get(1)));
        newMaxPathSum.add(maxSumAsBranch, maxPathSum);
        return newMaxPathSum;
    }

    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        BinaryTree b7 = new BinaryTree(7);
        BinaryTree b8 = new BinaryTree(8);
        BinaryTree b9 = new BinaryTree(9);
        BinaryTree b10 = new BinaryTree(10);
        b1.left= b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
        b4.left = b8;
        b4.right = b9;
        b5.left = b10;
        System.out.println(findMaxSum(b1));

    }
}
