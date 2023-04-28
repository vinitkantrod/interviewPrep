package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class LevelOrderTraversalTwo107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        if (root != null) q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> tempRes = new ArrayList<>();
            Queue<TreeNode> levelQueue = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode x = q.remove();
                if (x != null) levelQueue.add(x);
            }
            while (!levelQueue.isEmpty()) {
                TreeNode data = levelQueue.remove();
                tempRes.add(data.val);
                q.add(data.left);
                q.add(data.right);
            }
//            res.add(tempRes);
            s.add(tempRes);
        }
        while (!s.empty()) {
            List<Integer> tempRes = s.pop();
            if (tempRes.size() > 0) res.add(tempRes);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        System.out.println(Arrays.asList(levelOrderBottom(n)));
    }
}
