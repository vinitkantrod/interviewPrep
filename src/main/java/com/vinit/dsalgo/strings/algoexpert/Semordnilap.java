package com.vinit.dsalgo.strings.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Semordnilap {

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        // Write your code here.
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String, String> stringMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            if (stringMap.containsKey(words[i])) {
                res.add(new ArrayList<>(Arrays.asList(words[i], stringMap.get(words[i]))));
            } else {
                String palindromeStr = palindrome(words[i]);
                stringMap.put(palindromeStr, words[i]);
            }
        }
        return res;
    }

    public static String palindrome (String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int i = str.length() - 1;
        while (i >=0) {
            sb.append(str.charAt(i));
            i--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] s = {"diaper", "abc", "test", "cba", "repaid"};
        System.out.println(Arrays.asList(Arrays.asList(semordnilap(s))));
    }
}
