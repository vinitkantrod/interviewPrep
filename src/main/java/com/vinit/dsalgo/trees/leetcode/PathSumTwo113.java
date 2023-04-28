package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumTwo113 {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        dfs(root, targetSum, lst, res);
        return res;
    }

    public static void dfs(TreeNode root, int targetSum, List<Integer> lst, List<List<Integer>> res) {
        if (root == null) return;
        lst.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(lst));
        } else {
            dfs(root.left, targetSum, lst, res);
            dfs(root.right, targetSum, lst, res);
        }
        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        lst.remove(lst.size() - 1);
    }
    public static void main(String[] args) {

    }
}
