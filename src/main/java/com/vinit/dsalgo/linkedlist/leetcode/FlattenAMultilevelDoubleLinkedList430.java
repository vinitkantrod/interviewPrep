package com.vinit.dsalgo.linkedlist.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenAMultilevelDoubleLinkedList430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        };
    };

    public static Node flatten(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0, null, head, null);
        Deque<Node> stack = new ArrayDeque<>();
        Node prev = dummy;
        Node curr = dummy;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;
            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    public static void printLL(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
    }
}
