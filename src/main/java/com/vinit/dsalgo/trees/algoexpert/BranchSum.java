package com.vinit.dsalgo.trees.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSum {

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

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        branchSum(root,res,0);
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void branchSum(BinaryTree root, List<Integer> res, int sum) {
        if (root == null) {
            return;
        }
        sum += root.value;
        if (root.left == null && root.right == null) {
            res.add(sum);
        }
        branchSum(root.left, res, sum);
        branchSum(root.right, res, sum);
    }

    public static void main(String[] args) {
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
        branchSums(b1);
    }
}
