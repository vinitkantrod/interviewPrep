package com.vinit.dsalgo.algoexpert.binaryTree;

public class SymmetricalTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public boolean symmetricalTree(BinaryTree tree) {
        // Write your code here.
        return checkSymmetrical(tree.left, tree.right);
    }

    public Boolean checkSymmetrical(BinaryTree left, BinaryTree right) {
        if (left != null && right != null && left.value == right.value) {
            return checkSymmetrical(left.right, right.left) &&
                    checkSymmetrical(left.left, right.right);
        }
        return left == right;
    }
}
