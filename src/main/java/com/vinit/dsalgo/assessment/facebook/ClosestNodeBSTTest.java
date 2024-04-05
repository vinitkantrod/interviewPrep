package com.vinit.dsalgo.assessment.facebook;

public class ClosestNodeBSTTest {

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
    static Double minDiff = Double.MAX_VALUE;
    static int closestValue = -1;
    public static int closestValue(TreeNode root, double target) {
        if (root == null) return closestValue;
        if (root != null && target == root.val) {
            return root.val;
        }
        Double currMinDiff = Math.abs((double) root.val - target);
        if (currMinDiff <= minDiff) {
            System.out.println(currMinDiff == minDiff);
            if (currMinDiff.equals(minDiff))
                 if (root.val < closestValue) {
                     closestValue = root.val;
                 } else {
                     // do nothing
            } else {
                closestValue = root.val;
                minDiff = currMinDiff;
            }
        }
        System.out.println(root.val + " - " + minDiff + " _ " + currMinDiff +  " | " + closestValue);
        if (target < root.val) {
            closestValue = closestValue(root.left, target);
        }
        else {
            closestValue = closestValue(root.right, target);
        }
        return closestValue;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left= new TreeNode(2);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        t.right = new TreeNode(5);
        System.out.println(closestValue(t, 4.5));
    }
}
