package com.vinit.dsalgo.linkedlist.leetcode;


import java.util.Stack;

public class ConvertBSTToCircularLL426 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node head = null;
    public static Node treeToDoublyList(Node root) {
        if( root == null) return root;
        Node dummy = new Node(0);
        Node prev = dummy;
        Stack<Node> stack = new Stack();
        Node curr = root;

        while(!stack.isEmpty()|| curr != null){
            while(curr!= null){
                System.out.println("pushing " + (curr != null ? curr.val: null) + " to stack...");
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println("popping " + (curr != null ? curr.val: null));
            prev.right = curr;
            curr.left = prev;
            prev = curr;
            System.out.println("new prev: "+ (prev != null ? prev.val: null));
            curr = curr.right;
            System.out.println("new curr: " + (curr != null ? curr.val: null));
        }
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }

    public static void main(String[] args) {
        Node r = new Node(4);
        r.left = new Node(2);
        r.left.right = new Node(3);
        r.right = new Node(5);
        r.left.left = new Node(1);
        System.out.println(treeToDoublyList(r));
    }
}
