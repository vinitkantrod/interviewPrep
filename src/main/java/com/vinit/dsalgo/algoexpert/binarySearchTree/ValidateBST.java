package com.vinit.dsalgo.algoexpert.binarySearchTree;

import com.vinit.dsalgo.trees.narasimha_karumanchi_book.InOrderRecursiveTraversal;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Boolean validTree(BST node, int min, int max) {
        if (node.value < min || node.value >= max) return false;
        if (node.left != null && !validTree(node.left, min, node.value)) return false;
        if (node.right != null && !validTree(node.right, node.value, max)) return false;
        return true;
    }
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
