package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.Arrays;

public class BinaryTreeDiameter {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        int diameter = 0;
        return getDiameter(tree).diameter;
    }

    static class TreeInfo {
        int diameter;
        int height;
        public TreeInfo(int d, int h) {
            diameter = d;
            height = h;
        }
    }
    public static TreeInfo getDiameter(BinaryTree node) {
        if (node == null) return new TreeInfo(0,0);
        TreeInfo leftTree = getDiameter(node.left);
        TreeInfo rightTree = getDiameter(node.right);

        int longestPathThrough = leftTree.height + rightTree.height;
        int maxDiameterSoFar = Math.max(leftTree.diameter, rightTree.diameter);
        int currentDiameter = Math.max(longestPathThrough, maxDiameterSoFar);
        int currHeight = 1 + Math.max(leftTree.height, rightTree.height);
        return new TreeInfo(currentDiameter, currHeight);
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(1);
        r.left = new BinaryTree(3);
    }
}
