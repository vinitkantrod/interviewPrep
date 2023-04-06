/**
 * Link: https://leetcode.com/problems/truncate-sentence/
 */
package com.vinit.dsalgo.arrays.leetcode;

public class TruncateSentence {

    public static String truncateSentence(String s, int k) {
        String[] sArr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(sArr[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k) + "...");
    }
}
