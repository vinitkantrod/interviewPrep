package com.vinit.dsalgo.trees.narasimha_karumanchi_book;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElemInBinaryTree {

    public static BinaryTreeNode insertElemInBinaryTree(BinaryTreeNode root, int data) {
        if (root == null) return root;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp != null) {
                if (temp.getLeft() != null) q.offer(temp.getLeft());
                else {
                    temp.setLeft(new BinaryTreeNode(data));
                    return root;
                }
                if (temp.getRight() != null) q.offer(temp.getRight());
                else {
                    temp.setRight(new BinaryTreeNode(data));
                    return root;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode bt1 = new BinaryTreeNode(1);
        BinaryTreeNode bt2 = new BinaryTreeNode(2);
        BinaryTreeNode bt3 = new BinaryTreeNode(3);
        BinaryTreeNode bt4 = new BinaryTreeNode(4);
        BinaryTreeNode bt5 = new BinaryTreeNode(5);
        BinaryTreeNode bt6 = new BinaryTreeNode(6);
        BinaryTreeNode bt7 = new BinaryTreeNode(7);
        bt2.setLeft(bt4);
        bt2.setRight(bt5);
        bt3.setLeft(bt6);
        bt3.setRight(bt7);
        bt1.setLeft(bt2);
        bt1.setRight(bt3);
        System.out.println(insertElemInBinaryTree(bt1, 8));
        LevelOrderTraversal.levelOrderTraversal(bt1);
    }
}
