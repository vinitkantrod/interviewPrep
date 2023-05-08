package com.vinit.dsalgo.strings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordInAString151 {

    public static String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join( " ", wordList);
//        List<String> lst = new ArrayList<>();
//        String prevString = "";
//        for (String ss : s.trim().split(" ")) {
//            if (ss == "" && prevString == "") continue;
//            else {
//                lst.add(ss);
//                lst.add("");
//                prevString = "";
//            }
//        }
//        lst.remove(lst.size()-1);
//        int i = 0;
//        int j = lst.size() - 1;
//        StringBuffer sb = new StringBuffer();
//        while (j >=0) {
//            sb.append(lst.get(j--));
//        }
//        System.out.println(sb.toString().length());
//        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is    blue     "));
    }
}
