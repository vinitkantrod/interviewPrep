package com.vinit.dsalgo.tries;

import com.vinit.dsalgo.trees.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class TrieNode {
//    char val;
//    TrieNode[] children;
//    Boolean leafNode;
//    TrieNode(char ch) {
//        this.val = ch;
//        this.children = new TrieNode[26];
//        leafNode = true;
//    }
//}
//
//class Trie {
//    TrieNode root;
//    Trie() {
//        root = new TrieNode('/');
//    }
//
//    public void insert(String word) {
//        TrieNode traverse = root;
//        TrieNode[] ch = traverse.children;
//        int i = 0;
//        while (i < word.length()) {
//            char c = word.charAt(i);
//            if (ch[c - 'a'] == null) {
//                traverse = new TrieNode(c);
//                traverse.leafNode = false;
//                ch[c - 'a'] = traverse;
//            } else {
//                traverse = ch[c - 'a'];
//            }
//            ch = traverse.children;
//            i++;
//        }
//        if (i == word.length()) traverse.leafNode = true;
//    }
//
//    public List<String> suggest(String prefix, int suggestionCount) {
//        List<String> suggestions = new ArrayList<>();
//        TrieNode traverse = root;
//        TrieNode[] ch = traverse.children;
//        int i = 0;
//        while (i < prefix.length()) {
//            char c = prefix.charAt(i);
//            if (ch[c - 'a'] == null) {
//                return suggestions;
//            }
//            traverse = ch[c - 'a'];
//            ch = traverse.children;
//            i++;
//        }
//        while (suggestionCount > 0) {
//            StringBuilder sb = new StringBuilder(prefix);
//            Boolean leafNode = false;
//            while (!leafNode) {
//
//            }
//        }
//    }
//    private String getWord(String prefix) {
//        TrieNode traverse = root;
//        TrieNode[] ch = traverse.children;
//        int i = 0;
//        while (i < prefix.length()) {
//            char c = prefix.charAt(i);
//            if (ch[c - 'a'] == null) {
//
//            }
//            traverse = ch[c - 'a'];
//            ch = traverse.children;
//
//        }
//}

// Custom class Trie with function to get 3 words starting with given prefix
class Trie {

    // Node definition of a trie
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    };
    Node Root, curr;
    List<String> resultBuffer;

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3)
            return;
        if (curr.isWord)
            resultBuffer.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++)
            if (curr.children.get(c - 'a') != null)
                dfsWithPrefix(curr.children.get(c - 'a'), word + c);
    }
    Trie() {
        Root = new Node();
    }

    // Inserts the string in trie.
    void insert(String s) {

        // Points curr to the root of trie.
        curr = Root;
        for (char c : s.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                curr.children.set(c - 'a', new Node());
            curr = curr.children.get(c - 'a');
        }

        // Mark this node as a completed word.
        curr.isWord = true;
    }
    List<String> getWordsStartingWith(String prefix) {
        curr = Root;
        resultBuffer = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                return resultBuffer;
            curr = curr.children.get(c - 'a');
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
};
public class SearchSuggestionSystem1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Trie trie = new Trie();
            List<List<String>> result = new ArrayList<>();
            // Add all words to trie.
            for (String w : products)
                trie.insert(w);
            String prefix = new String();
            for (char c : searchWord.toCharArray()) {
                prefix += c;
                result.add(trie.getWordsStartingWith(prefix));
            }
            return result;
    }
}
