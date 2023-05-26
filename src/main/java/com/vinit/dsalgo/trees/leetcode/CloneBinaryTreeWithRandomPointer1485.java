package com.vinit.dsalgo.trees.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandomPointer1485 {
    public class Node {
      int val;
      Node left;
      Node right;
      Node random;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right, Node random) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.random = random;
      }
  }

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;
        NodeCopy() {}
        NodeCopy(int val) { this.val = val; }
        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    Map<Node, NodeCopy> seen = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        NodeCopy newRoot = dfs(root);
        return newRoot;
    }

    public NodeCopy dfs(Node root) {
        if (root == null) return null;
        if (seen.containsKey(root)) return seen.get(root);
        NodeCopy newNode = new NodeCopy(root.val);
        seen.put(root, newNode);
        newNode.left = dfs(root.left);
        newNode.right = dfs(root.right);
        newNode.random = dfs(root.random);
        return newNode;
    }
}
