package com.vinit.dsalgo.design.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignAddAndSearchWords211 {

    static class TrieNode {
        char node;
        TrieNode[] child;
        public TrieNode(char ch) {
            node = ch;
            child = new TrieNode[26];
        }
    }
    static class Tries {
        TrieNode root;
        public Tries() {
            root = new TrieNode('/');
        }
        public void addWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                TrieNode n = new TrieNode(c);
                if (current.child[index] == null ) current.child[index] = n;
                current = n;
            }
        }

        public Boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.child[index] != null && current.child[index].node == c) {
                    current = current.child[index];
                } else {
                    return false;
                }
            }
            return true;
        }
    }
    static class WordDictionary {
        Tries t;
        public WordDictionary() {
            t = new Tries();
        }

        public void addWord(String word) {
            t.addWord(word);
        }

        public boolean search(String word) {
            return t.search(word);
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("mad");
        System.out.println(obj.search("mad"));
    }
}
