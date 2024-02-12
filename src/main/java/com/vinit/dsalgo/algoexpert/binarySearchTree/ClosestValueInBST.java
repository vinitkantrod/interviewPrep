package com.vinit.dsalgo.algoexpert.binarySearchTree;

public class ClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        BST currentNode = tree;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value) ) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value){
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
