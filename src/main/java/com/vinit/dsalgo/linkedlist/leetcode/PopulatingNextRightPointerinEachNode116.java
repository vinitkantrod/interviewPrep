package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class PopulatingNextRightPointerinEachNode116 {

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        root.next = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            queue.add(new Node(1001));
            Node head = new Node(0);
            while (!queue.isEmpty() && queue.peek().val != 1001) {
                Node node = queue.poll();
                head.next = node;
                head = head.next;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            head.next = null;
            Node dummy = queue.poll();
        }

        return root;
    }

}
