package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class ReverseWordsInStringTwo186 {

    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseWord(s, 0, s.length - 1);
    }

    public static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }
    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
    }

    public static void reverseWord(char[] s, int start, int end) {
        int n = s.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && s[j] != ' ') j++;
            reverse(s, i, j-1);
            i = j+1;
            j = i;
        }
    }
}
