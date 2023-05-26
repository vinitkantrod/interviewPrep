package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfRootToLeafBinaryTree1022 {

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
    public static int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(list, root, "");
        System.out.println(Arrays.asList(list));
        int sum = 0;
        for (String s : list) {
//            System.out.println(Integer.parseInt(s, 2) + " - " + sum);
            sum += Integer.parseInt(s, 2);
        }
        return sum;
    }

    public static void dfs(List<String> list, TreeNode root, String s) {
        if (root == null) return;
//        System.out.println("val: " + root.val);
        s += root.val;
        if (root.left == null && root.right == null) {
            list.add(new String(s));
            return;
        }
//        System.out.println("adding: " + s);
        dfs(list, root.left, s);
        dfs(list, root.right, s);
        s = s.substring(0, s.length() - 1);
//        System.out.println("subString: " + s);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(0);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(1);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(t));

    }
}
