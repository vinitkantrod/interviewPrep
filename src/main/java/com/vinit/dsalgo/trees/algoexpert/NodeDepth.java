package com.vinit.dsalgo.trees.algoexpert;

import java.util.LinkedList;
import java.util.Queue;

public class NodeDepth {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // level order traversal
    public static int nodeDepths(BinaryTree root) {
        Integer sum = nodeDepth(root, 0, 0);
        System.out.println(sum);
        return sum;
    }

    public static Integer nodeDepth(BinaryTree root, int level, int sum) {
        if (root == null) return sum;
        sum += level;
        if (root.left == null && root.right == null) {
            return sum;
        }
        sum = nodeDepth(root.left, level + 1, sum);
        sum = nodeDepth(root.right, level + 1, sum);
        return sum;
    }

    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        BinaryTree b7 = new BinaryTree(7);
        BinaryTree b8 = new BinaryTree(8);
        BinaryTree b9 = new BinaryTree(9);
//        BinaryTree b10 = new BinaryTree(10);
        b1.left= b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
        b4.left = b8;
        b4.right = b9;
//        b5.left = b10;
        nodeDepths(b1);
    }
}
