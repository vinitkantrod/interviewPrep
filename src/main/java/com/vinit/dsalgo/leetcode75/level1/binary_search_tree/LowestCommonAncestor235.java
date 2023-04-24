package com.vinit.dsalgo.leetcode75.level1.binary_search_tree;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestor235 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Map<Integer, Integer> rootMap = new HashMap<>();
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root != null) {
//            TreeNode left = null;
//            TreeNode right = null;
//            if (p.val < q.val) {
//                left = p;
//                right = q;
//            } else {
//                left = q;
//                right = p;
//            }
//            return lcs(root, left, right);
//        }
//        return null;

        // LC code
        // If the root is null, then there is no LCA, so return null.
        if(root == null){
            return root;
        }

        // Get the value of the current node.
        int cur = root.val;

        // If both p and q are greater than the current node, then the LCA is in the right subtree.
        if(cur < p.val && cur < q.val){
            return lowestCommonAncestor(root.right, p, q); // Recurse on the right subtree.
        }
        // If both p and q are less than the current node, then the LCA is in the left subtree.
        if(cur > p.val && cur > q.val){
            return lowestCommonAncestor(root.left, p, q); // Recurse on the left subtree.
        }
        // Otherwise, the current node is the LCA.
        return root;
    }

    public static TreeNode lcs(TreeNode r, TreeNode p, TreeNode q) {
        System.out.println(r.val + " >> " + p.val + " _ " + q.val);
        if (p.val == r.val || q.val == r.val) return r;
        if (p.val < r.val && q.val > r.val) return r;
        if (p.val < r.val && q.val < r.val && r.left != null)
            return lcs(r.left, p, q);
        else if (p.val > r.val && q.val > r.val && r.right != null)
            return lcs(r.right, p, q);
        else
            return null;
    }

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(6);
//        TreeNode n2 = new TreeNode(2);TreeNode n3 = new TreeNode(8);
//        TreeNode n4 = new TreeNode(0);TreeNode n5 = new TreeNode(4);
//        TreeNode n6 = new TreeNode(3);TreeNode n7 = new TreeNode(5);
//        TreeNode n8 = new TreeNode(7);TreeNode n9 = new TreeNode(9);
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//        n5.left = n6;
//        n5.right = n7;
//        n3.left = n8;
//        n3.right = n9;

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        n1.right = n2;
        System.out.println(lowestCommonAncestor(n1, n3, n2).val);
    }
}
