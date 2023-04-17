package com.vinit.dsalgo.trees.algoexpert;

public class ClosestNodeinBST {

    static int minDiff = Integer.MAX_VALUE;
    static int closestValue = -1;
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        if (tree == null) return -1;
        minDiff = Math.abs(tree.value - target);
        closestValue = tree.value;
        System.out.println(minDiff + " : " + closestValue);
        if (tree != null && target == tree.value) {
            closestValue = tree.value;
        }
        else if (target < tree.value)
            nearestNnode(tree.left, target);
        else
            nearestNnode(tree.right, target);
        return closestValue;
    }

    public static void nearestNnode(BST tree, int target) {
        if (tree == null) return;
        if (target == tree.value) closestValue = tree.value;
        else if (Math.abs(tree.value - target) < minDiff) {
            minDiff = Math.abs(tree.value - target);
            closestValue = tree.value;
        }
        System.out.println(tree.value + " = " + minDiff + " : " + closestValue);
        if (target < tree.value)
            nearestNnode(tree.left, target);
        else
            nearestNnode(tree.right, target);
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
        BST t1 = new BST(10);
        BST t2 = new BST(5);
        BST t3 = new BST(15);
        BST t4 = new BST(2);
        BST t5 = new BST(5);
        BST t6 = new BST(13);
        BST t7 = new BST(22);
        BST t8 = new BST(1);
        BST t9 = new BST(14);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t6.right = t9;
        System.out.println(findClosestValueInBst(t1, 12));
    }
}
