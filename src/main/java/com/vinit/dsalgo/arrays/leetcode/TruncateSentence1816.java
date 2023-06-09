package com.vinit.dsalgo.arrays.leetcode;

public class TruncateSentence1816 {

    public String truncateSentence(String s, int k) {
        String[] ss = s.split(" " );
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(ss[i] + " ");
        }
        return sb.toString().trim();
    }
}
