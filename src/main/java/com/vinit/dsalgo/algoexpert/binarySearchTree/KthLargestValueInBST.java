package com.vinit.dsalgo.algoexpert.binarySearchTree;

import com.vinit.dsalgo.trees.algoexpert.KthLargestInBST;

public class KthLargestValueInBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public class TreeInfo {
        int numOfNodesVisited;
        int lastestVisitedNodeVal;
        public TreeInfo(int n, int v) {
            numOfNodesVisited = n;
            lastestVisitedNodeVal = v;
        }
    }
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraversal(tree, k, treeInfo);
        return treeInfo.lastestVisitedNodeVal;
    }

    private static void reverseInOrderTraversal(BST node, int k, TreeInfo tree) {
        if (node == null || tree.numOfNodesVisited >= k) return;
        reverseInOrderTraversal(node.right, k, tree);
        if (tree.numOfNodesVisited < k) {
            tree.numOfNodesVisited += 1;
            tree.lastestVisitedNodeVal = node.value;
            reverseInOrderTraversal(node.left, k, tree);
        }
    }
}
