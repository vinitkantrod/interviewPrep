package com.vinit.dsalgo.algoexpert.binarySearchTree;

import java.util.List;

public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return constructBST(array, 0, array.size() - 1);
    }

    private static BST constructBST(List<Integer> array, int startIdx, int endIdx) {
        if (endIdx < startIdx) return null;
        int midPoint = (startIdx + endIdx) / 2;
        BST bst = new BST(array.get(midPoint));
        bst.left = constructBST(array, startIdx, midPoint - 1);
        bst.right = constructBST(array, midPoint + 1, endIdx);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
