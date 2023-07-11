package com.vinit.dsalgo.trees.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PathSumThree437 {
    int count = 0;
    int k;
    Map<Long, Integer> h = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0L);
        return count;
    }

    private void preorder(TreeNode node, long currentSum) {
        if(node == null) return;
        currentSum += node.val;
        if (currentSum == k) count++;
        count += h.getOrDefault(currentSum - k, 0);
        h.put(currentSum, h.getOrDefault(currentSum, 0) + 1);
        preorder(node.left, currentSum);
        preorder(node.right, currentSum);
        h.put(currentSum, h.get(currentSum) - 1);
    }
}
