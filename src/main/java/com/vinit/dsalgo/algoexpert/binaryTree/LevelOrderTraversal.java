package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

    public static void levelOrderTraversal(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            queue.add(null);
            Queue<BinaryTree> levelQueue = new LinkedList<>();
            while (queue.peek() != null) {
                BinaryTree node = queue.poll();
                System.out.println(node.data);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            queue.poll();
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
        levelOrderTraversal(r);
    }
}
