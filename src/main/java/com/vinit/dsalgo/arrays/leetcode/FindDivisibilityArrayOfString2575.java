package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class FindDivisibilityArrayOfString2575 {

    public static int[] divisibilityArray(String word, int m) {
        int[] count = new int[word.length()];
        long num = 0;
        for (int i = 0; i < word.length(); i++) {
            long digit = word.charAt(i) - '0';
            num = (num * 10 + digit) % m;
            count[i] = num == 0 ? 1 : 0;
        }
        return count;
    }
    public static void main(String[] args) {
        String words = "998244353"; // m = 3 5292821435
//        String words = "1010"; // m = 10
        System.out.println(Arrays.toString(divisibilityArray(words, 3)));
    }
}
