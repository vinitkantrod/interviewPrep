package com.vinit.dsalgo.trees.leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST1214 {
    private void inorder(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        inorder(root1, set1);
        inorder(root2, set2);
        for (Integer i : set1) {
            if (set2.contains(target - i)) return true;
        }
        return false;
    }
}
