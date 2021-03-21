package com.vinit.dsalgo.trees.algoexpert;

public class HeightBinarySearchTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static class TreeInfo {
        public Boolean isBalance;
        public int height;

        public TreeInfo(Boolean isBalance, int he) {
            this.isBalance = isBalance;
            this.height = he;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalance;
    }

    public static TreeInfo getTreeInfo(BinaryTree node) {
        if (node == null) return new TreeInfo(true, -1);
        TreeInfo leftTree = getTreeInfo(node.left);
        TreeInfo rightTree = getTreeInfo(node.right);
        Boolean isBalance = leftTree.isBalance && rightTree.isBalance &&
                Math.abs(leftTree.height - rightTree.height) <= 1;
        int height = Math.max(leftTree.height, rightTree.height) + 1;
        return new TreeInfo(isBalance, height);
    }
}
