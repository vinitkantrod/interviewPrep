package com.vinit.dsalgo.trees.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNAryTree559 {

    class  Node {
        public int val;
        public List<Node> children;

    public Node() {}

    public Node(int _val) {
            val = _val;
        }

    public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return 0;
        if (root.children == null) return 1;
        int depth = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<Node> queue1 = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                if (n.children != null) {
                    for (Node x : n.children) {
                        queue1.add(x);
                    }
                }
            }
            while (!queue1.isEmpty()) {
                queue.add(queue1.poll());
            }
            depth++;
        }
        return depth;
    }
}
