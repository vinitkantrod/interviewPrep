package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoBT {

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

    public static void insert(BinaryTree root, BinaryTree node) {
        if (root == null) root = node;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree curr = queue.poll();
            System.out.println(curr.data);
            if (curr.left == null) {
                curr.left = node;
                return;
            }
            if (curr.right == null) {
                curr.right = node;
                return;
            }
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(1);
        r.left = new BinaryTree(2);
        r.right = new BinaryTree(3);
        r.left.left = new BinaryTree(4);
        r.left.right = new BinaryTree(5);
        insert(r, new BinaryTree(6));
    }
}
