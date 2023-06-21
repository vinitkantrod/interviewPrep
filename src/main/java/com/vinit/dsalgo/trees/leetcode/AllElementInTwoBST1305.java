package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class AllElementInTwoBST1305 {

    private void inorder(TreeNode root, Queue<Integer> queue) {
        if (root != null) {
            inorder(root.left, queue);
            queue.offer(root.val);
            inorder(root.right, queue);
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        inorder(root1, queue1);
        inorder(root2, queue2);
        List<Integer> output = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty() && !queue2.isEmpty()) {
                if (queue1.peek() < queue2.peek()) output.add(queue1.poll());
                else output.add(queue2.poll());
            }
            else if (!queue1.isEmpty()) output.add(queue1.poll());
            else if (!queue2.isEmpty()) output.add(queue2.poll());
        }
        System.out.println(Arrays.asList(output));
        return output;
    }
}
