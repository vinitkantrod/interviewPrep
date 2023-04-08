package com.vinit.dsalgo.strings.leetcode;

public class ReverseWordsInAString557 {

    public static String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str : sArr) {
            String newStr = reverseString(str);
            sb.append(newStr).append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseString(String s) {
        int i = 0;
        int j = s.length() - 1;
        System.out.println(s + " : " + i + " : " + j);
        StringBuffer sb = new StringBuffer(s);
        while(i < j){
            char temp = s.charAt(i);
            sb.setCharAt(i, s.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
