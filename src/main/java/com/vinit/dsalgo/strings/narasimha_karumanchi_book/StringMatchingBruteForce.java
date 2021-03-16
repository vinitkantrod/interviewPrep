package com.vinit.dsalgo.strings.narasimha_karumanchi_book;

import com.vinit.dsalgo.constants.StringConstants;

public class StringMatchingBruteForce {

    public static boolean strBruteForce(String str, String pattern) {
        if (pattern.length() == 0) return true;
        for (int i = 0; i < str.length() - pattern.length() + 1; i++) {
            int stri = i; int patterni = 0;
            while (stri < str.length() &&
                    patterni < pattern.length() &&
                    String.valueOf(str.charAt(stri)).equals(String.valueOf(pattern.charAt(patterni))) ) {
                stri++;
                patterni++;
            }
            if (patterni == pattern.length()) return true;
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(strBruteForce(StringConstants.LOWERCASE_ALPHABETS, "lmnop"));
        System.out.println(strBruteForce(StringConstants.LOWERCASE_ALPHABETS, "ac"));
        System.out.println(strBruteForce(StringConstants.LOWERCASE_ALPHABETS, ""));
        System.out.println(strBruteForce(StringConstants.LOWERCASE_ALPHABETS, "xyza"));
    }
}
