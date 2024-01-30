package com.vinit.dsalgo.algoexpert.binaryTree;

public class SplitBT {

    public class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int splitBinaryTree(BinaryTree tree) {
        // Write your code here.
        int treeSum = getSum(tree);
        if (treeSum % 2 == 1) return 0;
        int desiredSubTreeSum = treeSum / 2;
        Boolean canSplit = trySubTree(tree, desiredSubTreeSum).canSplit;
        return canSplit == true ? desiredSubTreeSum : 0;
    }
    public int getSum(BinaryTree node) {
        if (node == null) return 0;
        int ls = getSum(node.left);
        int rs = getSum(node.right);
        return node.value + ls + rs;
    }

    public ResultPair trySubTree(BinaryTree node, int desiredSum) {
        if (node == null) return new ResultPair(0, false);
        ResultPair left = trySubTree(node.left, desiredSum);
        ResultPair right = trySubTree(node.right, desiredSum);
        int currSum = node.value + left.treeSum + right.treeSum;
        Boolean canSplit = left.canSplit || right.canSplit || currSum == desiredSum;
        return new ResultPair(currSum, canSplit);
    }
    public class ResultPair {
        int treeSum;
        Boolean canSplit;

        public ResultPair(int t, Boolean canSplit) {
            this.treeSum = t;
            this.canSplit = canSplit;
        }
    }
}
