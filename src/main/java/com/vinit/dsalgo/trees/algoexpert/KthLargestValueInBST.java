package com.vinit.dsalgo.trees.algoexpert;

public class KthLargestValueInBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int noOfNodesVisited;
        public int lastestNodeVisitedValue;

        public TreeInfo(int n, int b) {
            this.noOfNodesVisited = n;
            this.lastestNodeVisitedValue = b;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraversal(tree, k, treeInfo);
        return treeInfo.lastestNodeVisitedValue;
    }

    public static void reverseInOrderTraversal(BST node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.noOfNodesVisited >= k) return;
        reverseInOrderTraversal(node.right, k, treeInfo);
        if (treeInfo.noOfNodesVisited < k) {
            treeInfo.noOfNodesVisited += 1;
            treeInfo.lastestNodeVisitedValue = node.value;
            reverseInOrderTraversal(node.left, k, treeInfo);
        }
    }

    public static void main(String args[]) {

    }
}
