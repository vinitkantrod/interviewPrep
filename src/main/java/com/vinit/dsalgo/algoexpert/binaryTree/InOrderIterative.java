package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.Stack;

public class InOrderIterative {

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

    public static void iterativeInOrder(BinaryTree tree) {
        if (tree == null) return;
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree currentNode = tree;
        Boolean done = false;
        while (!done) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.empty()) {
                    done = true;
                } else {
                    currentNode = stack.pop();
                    System.out.println(currentNode.data);
                    currentNode = currentNode.right;
                }
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
        iterativeInOrder(r);
    }
}
