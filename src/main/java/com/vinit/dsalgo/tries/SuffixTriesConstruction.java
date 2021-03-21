package com.vinit.dsalgo.tries;

import java.util.HashMap;
import java.util.Map;

public class SuffixTriesConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // O(n^2) | O(n^2)
        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            for (int i = 0; i < str.length(); i++) insertSubstringStartingAt(i, str);
        }

        // O(m) - m is length of the substring (str)
        public boolean contains(String str) {
            // Write your code here.
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                if (!node.children.containsKey(str.charAt(i))) return false;
                node = node.children.get(str.charAt(i));
            }
            return node.children.containsKey(endSymbol);
        }

        public void insertSubstringStartingAt(Integer currentIdx, String str) {
            TrieNode node = root;
            for (int j = currentIdx; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) node.children.put(letter, new TrieNode());
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }
    }

    public static void main(String args[]) {
        SuffixTrie suffixTrie = new SuffixTrie("babc");
        System.out.println(suffixTrie.contains("abc"));
        System.out.println(suffixTrie.contains("ab"));
    }
}
