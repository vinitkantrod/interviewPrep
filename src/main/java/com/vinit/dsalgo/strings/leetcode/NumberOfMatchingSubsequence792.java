package com.vinit.dsalgo.strings.leetcode;

import java.util.ArrayList;

public class NumberOfMatchingSubsequence792 {

    public static int numMatchingSubseq(String s, String[] words) {

        // Time limit exceed
//        int count = 0;
//        for (String ss: words) {
//            int j = 0;
//            int k = 0;
//            while (j < ss.length() && k < s.length()) {
//                if (ss.charAt(j) == s.charAt(k)) {
//                    j++;
//                    k++;
//                } else {
//                    k++;
//                }
//            }
//            if (j == ss.length()) count++;
//        }
//        return count;

        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c: s.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node: old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

    static class Node {
        String word;
        int index;
        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }
}
