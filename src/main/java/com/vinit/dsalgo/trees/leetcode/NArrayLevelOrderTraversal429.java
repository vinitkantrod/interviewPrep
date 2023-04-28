package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class NArrayLevelOrderTraversal429 {

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> levelOrder(Node root) {

        Queue<Node> treeNodeQueue = new LinkedList<>();
        if (root != null) treeNodeQueue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> tempRes = new ArrayList<>();
            Queue<Node> levelQueue = new LinkedList<>();
            while (!treeNodeQueue.isEmpty()) {
                Node x = treeNodeQueue.remove();
                if (x != null) levelQueue.add(x);
            }
            while (!levelQueue.isEmpty()) {
                Node data = levelQueue.remove();
                tempRes.add(data.val);
                if (data.children != null && data.children.size() > 0) {
                    for (int i = 0; i < data.children.size(); i++) {
                        treeNodeQueue.add(data.children.get(i));
                    }
                }
            }
            res.add(tempRes);
        }
        return res;
    }



    public static void level(Node root) {

    }
    public static void main(String[] args) {
        Node n = new Node(1);
        List<Node> n1=new ArrayList<>();
        n1.add(new Node(3));
        n1.add(new Node(2));
        n1.add(new Node(4));
        n.children = n1;
        List<Node> n2 = new ArrayList<>();
        n2.add(new Node(5));
        n2.add(new Node(6));
        n1.get(0).children = n2;
        System.out.println(Arrays.asList(levelOrder(n)));
    }
}
