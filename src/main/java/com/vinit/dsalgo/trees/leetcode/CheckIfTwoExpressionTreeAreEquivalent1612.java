package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckIfTwoExpressionTreeAreEquivalent1612 {

    static class Node {
      char val;
      Node left;
      Node right;
      Node() {this.val = ' ';}
      Node(char val) { this.val = val; }
      Node(char val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static boolean checkEquivalence(Node root1, Node root2) {
        List<Character> c1 = new ArrayList<>();
        List<Character> c2 = new ArrayList<>();
        getList(root1, c1);
        System.out.println(Arrays.asList(c1));
        getList(root2, c2);
        System.out.println(Arrays.asList(c2));
        Collections.sort(c1);
        Collections.sort(c2);
        return check(c1, c2);
    }

    public static void getList(Node root, List<Character> c) {
        if (root.val != '+') {
            c.add(root.val);
            return;
        }
        getList(root.left, c);
        getList(root.right, c);
    }

    public static Boolean check(List<Character> c1, List<Character> c2) {
        if (c1.size() != c2.size()) return false;
        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i) != c2.get(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Node n1 = new Node('+');
        n1.left = new Node('a');
        n1.right = new Node('+');
        n1.right.right = new Node('b');
        n1.right.left = new Node('c');
        Node n2 = new Node('+');
        n2.left = new Node('+');
        n2.right = new Node('a');
        n2.left.right = new Node('c');
        n2.left.left = new Node('b');
        System.out.println(checkEquivalence(n1, n2));
    }
}
