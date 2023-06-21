package com.vinit.dsalgo.trees.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LCSOfBSTFour1676 {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes){
        Set<Integer> set = new HashSet<>();
        for(TreeNode t: nodes) set.add(t.val);
        System.out.println(set);
        return dfs(root,set);
    }

    private static TreeNode dfs(TreeNode root, Set<Integer> set){
        if(root == null) return null;
        if(set.contains(root.val)) return root;

        TreeNode left = dfs(root.left, set);
        TreeNode right = dfs(root.right, set);
        if(left == right) return null;
        else if(left !=null && right != null) return root;
        else if(left == null) return right;
        else return left;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);
        TreeNode[] val = {new TreeNode(7), new TreeNode(6), new TreeNode(2), new TreeNode(4)};
        System.out.println(lowestCommonAncestor(t, val).val);
    }
}
