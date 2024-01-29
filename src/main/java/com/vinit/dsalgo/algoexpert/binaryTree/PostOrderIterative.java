package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.Stack;

public class PostOrderIterative {

    public static class BinaryTree {
        int data;
        InOrderIterative.BinaryTree left;
        InOrderIterative.BinaryTree right;

        public BinaryTree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void iterativePostOrder(BinaryTree tree) {
        Stack<BinaryTree> stack = new Stack<>();

    }
}
