package com.vinit.dsalgo.algoexpert.strings;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        // Write your code here.
        int i = 0;
        int j = str.length() - 1;
        while ( i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
