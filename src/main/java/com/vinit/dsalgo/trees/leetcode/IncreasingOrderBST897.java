package com.vinit.dsalgo.trees.leetcode;

import com.vinit.dsalgo.linkedlist.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderBST897 {

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> vals = new ArrayList<>();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0); TreeNode curr = ans;
        for (TreeNode v : vals) {
            curr.right = v;
            curr = curr.right;
        }
        return ans.right;
    }

    public static void inorder(TreeNode root, List<TreeNode> vals) {
        if (root == null) return;
        inorder(root.left, vals);
        vals.add(root);
        inorder(root.right, vals);
    }
}
