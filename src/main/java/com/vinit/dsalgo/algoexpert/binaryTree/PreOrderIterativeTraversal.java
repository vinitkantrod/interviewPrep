package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterativeTraversal {

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

    public static void iterativePreOrder(BinaryTree tree) {
        Stack<BinaryTree> stack = new Stack<>();
        if (tree == null) return;
        stack.push(tree);
        while (!stack.empty()) {
            BinaryTree node = stack.pop();
            System.out.println(node.data);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
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
        iterativePreOrder(r);
    }
}
