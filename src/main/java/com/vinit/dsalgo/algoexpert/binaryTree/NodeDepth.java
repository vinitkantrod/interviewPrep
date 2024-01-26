package com.vinit.dsalgo.algoexpert.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeDepth {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        List<Integer> integers = new ArrayList<>();
        int totalDepth = getNodeDepths(root, 0, 0);
        System.out.println(totalDepth);
        return totalDepth;
    }

    public static int getNodeDepths(BinaryTree node, int totalDepth, int sum) {
        if (node == null) return totalDepth;
        totalDepth += sum;
        if (node.left == null && node.right == null) {
            System.out.println(node.value + " " + totalDepth);
            return totalDepth;
        }
        totalDepth = getNodeDepths(node.left, totalDepth, sum + 1);
        totalDepth = getNodeDepths(node.right, totalDepth, sum + 1);
        return totalDepth;
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(1);
        r.left = new BinaryTree(2);
        r.right = new BinaryTree(3);
        r.left.left = new BinaryTree(4);
        r.left.right = new BinaryTree(5);
        r.left.left.left = new BinaryTree(8);
        r.left.left.right = new BinaryTree(9);
        r.right.left = new BinaryTree(6);
        r.right.right = new BinaryTree(7);
        System.out.println(Arrays.asList(nodeDepths(r)));
    }

}
