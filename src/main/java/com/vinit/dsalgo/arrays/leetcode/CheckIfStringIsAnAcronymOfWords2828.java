package com.vinit.dsalgo.arrays.leetcode;

import java.util.List;

public class CheckIfStringIsAnAcronymOfWords2828 {

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w.charAt(0));
        }
        System.out.println(sb.toString());
        return sb.toString().equals(s);
    }
}
