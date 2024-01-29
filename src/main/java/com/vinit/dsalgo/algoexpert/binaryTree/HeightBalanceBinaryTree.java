package com.vinit.dsalgo.algoexpert.binaryTree;

public class HeightBalanceBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return checkHeight(tree) > 0;
    }

    public static int checkHeight(BinaryTree node) {
        if (node == null) return 0;
        int lh = checkHeight(node.left);
        if (lh == -1) return -1;
        int rh = checkHeight(node.right);
        if (rh == -1) return -1;
        if (Math.abs(rh - lh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(1);
        r.left = new BinaryTree(2);
        r.right = new BinaryTree(3);
        r.left.left = new BinaryTree(4);
        r.left.right = new BinaryTree(5);
        r.left.right.left = new BinaryTree(7);
        r.left.right.right = new BinaryTree(8);
        r.right.right = new BinaryTree(6);
        System.out.println(heightBalancedBinaryTree(r));
    }
}
