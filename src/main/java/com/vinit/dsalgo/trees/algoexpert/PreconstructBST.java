package com.vinit.dsalgo.trees.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class PreconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }
        int rightSubTreeIndex = preOrderTraversalValues.size();
        int currentIndex = preOrderTraversalValues.get(0);

        for (int i = 1; i< preOrderTraversalValues.size(); i++) {
            int value = preOrderTraversalValues.get(i);
            if (value > preOrderTraversalValues.get(currentIndex)) {
                rightSubTreeIndex = i;
                break;
            }
        }
        BST leftSubTree = reconstructBst(new ArrayList<>(preOrderTraversalValues.subList(1, rightSubTreeIndex)));
        BST rightSubTree = reconstructBst(new ArrayList<Integer>(preOrderTraversalValues.subList(rightSubTreeIndex, preOrderTraversalValues.size())));
        BST bst = new BST(currentIndex);
        bst.left = leftSubTree;
        bst.right = rightSubTree;
        return bst;
    }
}
