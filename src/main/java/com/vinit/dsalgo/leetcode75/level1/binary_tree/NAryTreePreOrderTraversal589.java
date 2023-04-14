package com.vinit.dsalgo.leetcode75.level1.binary_tree;

import com.vinit.dsalgo.linkedlist.algoexpert.MiddleNode;

import java.util.*;
import java.util.stream.Collectors;

public class NAryTreePreOrderTraversal589 {
    public static List<Integer> preorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
//        if (root != null) stack.push(root);
//        while (!stack.empty()) {
//            Node top = stack.pop();
//            System.out.println("top: " + top.val);
//            res.add(top.val);
//            List<Node> tempList = top.children;
//            if (top.children != null && top.children.size() > 0)
//            {
//                int n = top.children.size() - 1;
//                for (int i = n; i >= 0; i--) {
//                    System.out.println("pushing in stack: " + top.children.get(i).val);
//                    stack.push(top.children.get(i));
//                }
//            }
//            System.out.println(res);
//        }
//        return res;

        // LC code
        LinkedList<Integer> list=new LinkedList<>();

        if(root ==null)
            return list;

        preOrderTraversal(root,list);

        return list;
    }

    public static List<Integer> preOrderTraversal(Node root,List<Integer> list){
        list.add(root.val);
        if (root.children != null &&  root.children.size() > 0) {
            for (Node n : root.children) {
                preOrderTraversal(n, list);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> level1 = new ArrayList<>();
        level1.add(n2);
        level1.add(n3);
        level1.add(n4);
        n1.children = level1;
        List<Node> level2 = new ArrayList<>();
        level2.add(n5);
        level2.add(n6);
        n2.children = level2;
        preorder(n1);

    }
}

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