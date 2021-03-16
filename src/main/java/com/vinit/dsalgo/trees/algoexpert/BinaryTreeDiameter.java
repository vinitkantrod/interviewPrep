package com.vinit.dsalgo.trees.algoexpert;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeDiameter {

    public static int binaryTreeDiameter(BinaryTree tree) {
        if (tree == null) return 0;
        int lHeight = height(tree.left);
        int rHeight = height(tree.right);

        int lDiameter = binaryTreeDiameter(tree.left);
        int rDiameter = binaryTreeDiameter(tree.right);
        return Math.max(1+ lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    public static int height(BinaryTree tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }
    public static void levelOrderTraversal(BinaryTree root) {
        if (root == null) return;
        Queue<BinaryTree> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTree curr = q.poll();
            System.out.print(curr.value + " ");
            if(curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
    }

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
    public static void main(String args[]) {
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        BinaryTree b7 = new BinaryTree(7);
        BinaryTree b8 = new BinaryTree(8);
        BinaryTree b9 = new BinaryTree(9);
        BinaryTree b10 = new BinaryTree(10);
        b1.left= b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
        b4.left = b8;
        b4.right = b9;
        b5.left = b10;
        System.out.println(binaryTreeDiameter(b1));
        levelOrderTraversal(b1);
    }
}
