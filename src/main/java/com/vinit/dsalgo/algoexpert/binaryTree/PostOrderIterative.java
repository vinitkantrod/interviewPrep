package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.Stack;

public class PostOrderIterative {

    public static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void iterativePostOrder(BinaryTree root) {

        // https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
        Stack<BinaryTree> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) return;
            root = stack.pop();
            if (!stack.empty() && stack.peek() == root) root = root.right;
            else {
                System.out.println(root.data);
                root = null;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(1);
        r.left = new BinaryTree(2);
        r.right = new BinaryTree(3);
        r.left.left = new BinaryTree(4);
        r.left.right = new BinaryTree(5);
        r.right.left = new BinaryTree(6);
        r.right.right = new BinaryTree(7);
        iterativePostOrder(r);
    }
}
