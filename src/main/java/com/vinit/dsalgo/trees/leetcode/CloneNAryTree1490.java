package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    Map<Node, Node> clonedTree = new HashMap<>();
    public Node cloneTree(Node root) {
        if (root == null) return root;
        if (clonedTree.containsKey(root)) return clonedTree.get(root);
        Node clonedNode = new Node(root.val, new ArrayList<>());
        for (Node neighbour : root.children) {
            clonedNode.children.add(cloneTree(neighbour));
        }
        return clonedNode;
    }
}

public class CloneNAryTree1490 {
}
