package com.vinit.dsalgo.trees.algoexpert;

import java.util.function.Function;

public class IterativeInOrderTraversal {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree previousNode = null;
        BinaryTree currentNode = tree;
        while (currentNode != null) {
            BinaryTree nextNode;
            if (previousNode == null || previousNode == currentNode.parent) {
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if (previousNode == currentNode.left) {
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

    public static void main(String args[]) {
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
    }
}
