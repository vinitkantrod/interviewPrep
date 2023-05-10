package com.vinit.dsalgo.leetcode75.level1.design;

class Trie {
    class Node {
        char val;
        Node[] children;

        Boolean leafNode;

        Node() {
        }

        Node(char c) {
            this.val = c;
            leafNode = true;
            children = new Node[26];
        }

        Node(char c, Node[] ch) {this.val = c; this.children = ch;}
    }

    Node root;
    public Trie() {
        root = new Node('/');
        root.children = new Node[26];
    }

    public void insert(String word) {
        Node traverse = root;
        Node[] ch = traverse.children;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (ch[c - 'a'] == null) {
                traverse = new Node(c);
                traverse.leafNode = false;
                ch[c - 'a'] = traverse;
                ch = traverse.children;
            } else {
                traverse = ch[c - 'a'];
                ch = traverse.children;
            }
            i++;
        }
        if (i == word.length()) traverse.leafNode = true;
    }

    public boolean search(String word) {
        Node traverse = root;
        Node[] ch = traverse.children;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            System.out.println(c);
            if (ch[c - 'a'] == null) return false;
            traverse = ch[c - 'a'];
            ch = traverse.children;
            i++;
            System.out.println(i);
        }
        if (i == word.length() && traverse.leafNode) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Node traverse = root;
        Node[] ch = traverse.children;
        int i = 0;
        while (i < prefix.length()) {
            char c = prefix.charAt(i);
            if (ch[c - 'a'] == null) return false;
            traverse = ch[c - 'a'];
            ch = traverse.children;
            i++;
        }
        return true;
    }
}
public class ImplementTrie208 {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_4 = obj.search("app");
        boolean param_3 = obj.startsWith("app");
        System.out.println(param_2);
        System.out.println(param_4);
        System.out.println(param_3);
    }
}
