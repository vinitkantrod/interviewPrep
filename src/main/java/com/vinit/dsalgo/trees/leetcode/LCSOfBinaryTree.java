package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class LCSOfBinaryTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//        # If looking for me, return myself
//        if root == p or root == q:
//        return root
//
//        left = right = None
//        # else look in left and right child
//        if root.left:
//        left = self.lowestCommonAncestor(root.left, p, q)
//        if root.right:
//        right = self.lowestCommonAncestor(root.right, p, q)
//
//        # if both children returned a node, means
//        # both p and q found so parent is LCA
//        if left and right:
//        return root
//        else:
//        # either one of the chidren returned a node, meaning either p or q found on left or right branch.
//        # Example: assuming 'p' found in left child, right child returned 'None'. This means 'q' is
//        # somewhere below node where 'p' was found we dont need to search all the way,
//        # because in such scenarios, node where 'p' found is LCA
//        return left or right
//
        if (root == p || root == q) return root;
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null)
            left = lowestCommonAncestor(root.left, p, q);
        if (root.right != null)
            right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else
            return left != null ? left : right;
//        getParentForAllNodes(root);
//        System.out.println(parentMap);
//        Set<TreeNode> treeNodeSet = new HashSet<>();
//        treeNodeSet.add(p);
//        treeNodeSet.add(q);
//        TreeNode leftParent = parentMap.get(p);
//        TreeNode rightParent = parentMap.get(q);
//        if (leftParent == null) return p;
//        if (rightParent == null) return q;
//        treeNodeSet.add(leftParent);
//        treeNodeSet.add(rightParent);
//        System.out.println(treeNodeSet.size());
//        while (leftParent != rightParent) {
//            TreeNode newLeftParent = parentMap.get(leftParent);
//            TreeNode newRightParent = parentMap.get(rightParent);
//            if (newLeftParent == null) {
//                System.out.println("null left parent: " + leftParent.val);
//                return leftParent;
//            }
//            if (newRightParent == null) {
//                System.out.println("null right parent: " + rightParent.val);
//                return rightParent;
//            }
//            System.out.println(newLeftParent.val + " - " + newRightParent.val);
//            if (newRightParent == newRightParent) {
//                System.out.println("val: " + newLeftParent.val);
//                return newLeftParent;
//            }
//            if (treeNodeSet.contains(newLeftParent)) {
//                System.out.println("left val parent: " + newLeftParent.val);
//                return newLeftParent;
//            } else
//                treeNodeSet.add(newLeftParent);
//            if (treeNodeSet.contains(newRightParent)) {
//                System.out.println("right val parent: " + newRightParent.val);
//                return newRightParent;
//            } else
//                treeNodeSet.add(newRightParent);
//            leftParent = newLeftParent;
//            rightParent = newRightParent;
//        }
//        System.out.println("root: " + root.val);
//        return root;
    }

    public static void getParentForAllNodes(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        parentMap.put(root, null);
        while (!nodeQueue.isEmpty()) {
            TreeNode n = (TreeNode) nodeQueue.remove();
            if (n.left != null) {
                nodeQueue.add(n.left);
                if (!parentMap.containsKey(n.left)) parentMap.put(n.left, n);
            }
            if (n.right != null) {
                nodeQueue.add(n.right);
                if (!parentMap.containsKey(n.right)) parentMap.put(n.right, n);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);TreeNode n9 = new TreeNode(4);
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
