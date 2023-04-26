package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostOrderTraversal590 {

    class Node {
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

    static List<Integer> traversal = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return traversal;
    }

    public static void dfs(Node root) {
        if (root == null) return;
        if (root.children.size() > 0) {
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i));
            }
        }
        traversal.add(root.val);
    }
}
