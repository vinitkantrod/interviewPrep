package com.vinit.dsalgo.leetcode75.level1.binary_tree;

import java.util.*;

public class LevelOrderTraversal {

    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if (root != null) treeNodeQueue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> tempRes = new ArrayList<>();
            Queue<TreeNode> levelQueue = new LinkedList<>();
            while (!treeNodeQueue.isEmpty()) {
                TreeNode x = treeNodeQueue.remove();
                if (x != null) levelQueue.add(x);
            }
            while (!levelQueue.isEmpty()) {
                TreeNode data = levelQueue.remove();
                tempRes.add(data.val);
                if (data.left != null) treeNodeQueue.add(data.left);
                if (data.right != null) treeNodeQueue.add(data.right);
            }
            res.add(tempRes);
        }
        return res;
        }
}
