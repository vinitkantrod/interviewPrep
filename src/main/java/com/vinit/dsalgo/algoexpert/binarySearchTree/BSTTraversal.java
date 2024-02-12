package com.vinit.dsalgo.algoexpert.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        inOrder(tree, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        preOrder(tree, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        postOrder(tree, array);
        return array;
    }

    private static void inOrder(BST node, List<Integer> array) {
        if (node != null) {
            inOrder(node.left, array);
            array.add(node.value);
            inOrder(node.right, array);
        }
    }

    private static void preOrder(BST node, List<Integer> array) {
        if (node != null) {
            inOrder(node.left, array);
            array.add(node.value);
            inOrder(node.right, array);
        }
    }

    private static void postOrder(BST node, List<Integer> array) {
        if (node != null) {
            inOrder(node.left, array);
            array.add(node.value);
            inOrder(node.right, array);
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
