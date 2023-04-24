package com.vinit.dsalgo.trees.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LCSOfBinaryTreeTwo1644 {

    static int count = 0;
    static Map<TreeNode, Boolean> treeNodeMap = new HashMap<>();
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        treeNodeMap.put(p, false);
//        treeNodeMap.put(q, false);
//        isNodeExist(root, p);
//        isNodeExist(root, q);
//        if (!treeNodeMap.get(p) || !treeNodeMap.get(q)) return null;
        TreeNode rootNode = getLCS(root, p, q);
        return (count == 2) ? rootNode : null;
    }

    public static TreeNode getLCS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = getLCS(root.left, p, q);
        TreeNode right = getLCS(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }

    public static void isNodeExist(TreeNode root, TreeNode n) {
        if (treeNodeMap.get(n)) return;
        if (root == n) {
            treeNodeMap.put(n, true);
        }
        if (root.left != null) isNodeExist(root.left, n);
        if (root.right != null) isNodeExist(root.right, n);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n8;
        n5.right = n9;
        n3.left = n6;
        n3.right = n7;
        System.out.println(lowestCommonAncestor(n1, n2, n9));
    }
}
