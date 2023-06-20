package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBST95 {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return  new ArrayList<>();
        return generate_tree(1, n);
    }

    public static List<TreeNode> generate_tree(int start, int end) {
        List<TreeNode> allTree = new ArrayList<>();
        if (start > end) {
            allTree.add(null);
            return allTree;
        }
        for (int i = start; i <= end; i++) {
            System.out.println("I: " + i);
            List<TreeNode> leftTree = generate_tree(start, i - 1);
            System.out.println("start: " + start + ", end: " + (i - 1) + ", list: " + Arrays.asList(leftTree));
            List<TreeNode> rightTree = generate_tree(i + 1, end);
            System.out.println("start: " + (i + 1) + ", end: " + end + ", list: " + Arrays.asList(rightTree));

            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    System.out.println("l: " + (l != null? l.val : null) + " :: r: " + (r != null ? r.val : null));
                    TreeNode current = new TreeNode();
                    current.left = l;
                    current.right = r;
                    allTree.add(current);
                }
            }
        }
        return allTree;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.asList(generateTrees(2)));
    }
}
