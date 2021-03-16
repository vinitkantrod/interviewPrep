package com.vinit.dsalgo.trees.algoexpert;

public class KthLargestInBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInorderTraversal(tree, k, treeInfo);
        return treeInfo.lastVisitedNodeValue;
    }

    public class TreeInfo {
        public int noOfNodesVisited;
        public int lastVisitedNodeValue;

        public TreeInfo(int n, int v) {
            this.noOfNodesVisited = n;
            this.lastVisitedNodeValue = v;
        }
    }


    public static void reverseInorderTraversal(BST tree, int k, TreeInfo treeInfo) {
        if (tree == null || treeInfo.noOfNodesVisited >= k) return;
        reverseInorderTraversal(tree.right, k, treeInfo);
        if (treeInfo.lastVisitedNodeValue < k) {
            treeInfo.noOfNodesVisited += 1;
            treeInfo.lastVisitedNodeValue = tree.value;
            reverseInorderTraversal(tree.left, k, treeInfo);
        }
    }

}

