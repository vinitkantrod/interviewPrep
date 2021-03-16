package com.vinit.dsalgo.trees.narasimha_karumanchi_book;

import java.util.Stack;

public class PostOrderNonRecursiveTraversal {

    public static void postOrderNonRecursiveTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<>();
        if (root == null) return;
        s.push(root);
        Boolean done = false;
        BinaryTreeNode prev = null;
        while (!s.empty()) {
            BinaryTreeNode currentNode = s.peek();
            if (prev == null || prev.getLeft() == currentNode || prev.getRight() == currentNode) {
                if (currentNode.getLeft() != null) s.push(currentNode.getLeft());
                else if (currentNode.getRight() != null) s.push(currentNode.getRight());
                else {
                    s.pop();
                    System.out.print(currentNode.getData() + " ");
                }
            } else if (currentNode.getLeft() != prev) {
                if (currentNode.getRight() != null) {
                    s.push(currentNode.getRight());
                }else {
                    s.pop();
                    System.out.print(currentNode.getData() + " ");
                }
            } else {
                s.pop();
                System.out.print(currentNode.getData() + " ");
            }
            prev = currentNode;
        }
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
        postOrderNonRecursiveTraversal(bt1);
    }
}
