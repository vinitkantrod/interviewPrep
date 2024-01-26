package com.vinit.dsalgo.algoexpert.binaryTree;

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) return;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        if (tree.left == null && tree.right == null) return;
        if (tree.left != null && tree.right != null) {
            BinaryTree tempNode = tree.left;
            tree.left = tree.right;
            tree.right = tempNode;
        } else if (tree.left != null) {
            tree.right = tree.left;
            tree.left = null;
        } else {
            tree.left = tree.right;
            tree.right = null;
        }
    }

    public static void main(String[] args) {
                BinaryTree r = new BinaryTree(1);
//        r.left = new BinaryTree(2);
//        r.right = new BinaryTree(3);
//        r.left.left = new BinaryTree(4);
//        r.left.right = new BinaryTree(5);
//        r.left.left.left = new BinaryTree(8);
//        r.left.left.right = new BinaryTree(9);
//        r.right.left = new BinaryTree(6);
//        r.right.right = new BinaryTree(7);
        invertBinaryTree(r);

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
