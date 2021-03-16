package com.vinit.dsalgo.trees.narasimha_karumanchi_book;

public class MaximumElementInBinaryTree {

    public static int maxElement(BinaryTreeNode root) {
        int maxElem = Integer.MIN_VALUE;
        if (root == null) return maxElem;
        int leftMax = maxElement(root.getLeft());
        int rightMax = maxElement(root.getRight());
        if (leftMax > rightMax) maxElem = leftMax;
        else maxElem = rightMax;
        if (root.getData() > maxElem) maxElem = root.getData();
        return maxElem;
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
        System.out.println(maxElement(bt1));
    }
}
