package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBT {

    public static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static int size(BinaryTree root) {
        int leftSize = root.left == null ? 0 : size(root.left);
        int rightSize = root.right == null ? 0 : size(root.right);
        return 1 + leftSize + rightSize;
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(1);
        r.left = new BinaryTree(2);
        r.right = new BinaryTree(3);
        r.left.left = new BinaryTree(4);
        r.left.right = new BinaryTree(5);
        r.right.right = new BinaryTree(6);
        System.out.println(size(r));
    }
}
