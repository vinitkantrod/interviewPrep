package com.vinit.dsalgo.algoexpert.binaryTree;

public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if (node.right != null) return getLeftMostChild(node.right);
        return getRightMostParent(node);
    }

    public static BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public static BinaryTree getRightMostParent(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.parent != null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }
}
