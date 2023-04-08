package com.vinit.dsalgo.strings.leetcode;

import java.util.Arrays;

public class ReverseString344 {

    public static void reverseString(char[] s) {
        int leftPtr = 0;
        int rightPtr = s.length - 1;
        while (leftPtr < rightPtr) {
            char temp = s[leftPtr];
            s[leftPtr] = s[rightPtr];
            s[rightPtr] = temp;
            leftPtr++;
            rightPtr--;
        }
    }
    public static void main(String[] args) {
        char[] s = {};
        reverseString(s);
    }
}
