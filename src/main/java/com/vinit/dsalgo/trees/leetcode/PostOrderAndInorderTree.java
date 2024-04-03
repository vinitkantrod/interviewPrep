package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class PostOrderAndInorderTree {

    static class TreeNode  {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            data = val;
        }
    }
    public static void generateTree(int[] postOrder, int[] inOrder) {
        int n = postOrder.length;
        TreeNode root = createTree(postOrder, inOrder, 0, n - 1, 0, n - 1);
        printInorder(root);
    }

    private static TreeNode createTree(int[] postOrder, int[] inOrder, int Ps, int Pe, int Is, int Ie) {
        if (Is > Ie) return null;
        int rootVal = postOrder[Pe];
        TreeNode root = new TreeNode(rootVal);

        int ri = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootVal) {
                ri = i;
                break;
            }
        }
        int lIs = Is;
        int lIe = ri - 1;
        int rIs = ri + 1;
        int rIe = Ie;
        int lPs = Ps;
        int lPe = Ps + lIe - lIs;
        int rPs = lPe + 1;
        int rPe = Pe - 1;
        System.out.println("Root val: " + rootVal + " index: " + ri);

        root.left = createTree(postOrder, inOrder, lPs, lPe, lIs, lIe);
        root.right = createTree(postOrder, inOrder, rPs, rPe, rIs, rIe);

        return root;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + ", ");
        printInorder(root.left);
        printInorder(root.right);
    }
    public static void main(String[] args) {
        int[] p = new int[]{9,15,7,20,3};
        int[] i = new int[]{9,3,15,20,7};
        generateTree(p, i);
    }
}
