package com.vinit.dsalgo.stack.leetcode;

public class RemoveAllDuplicateAdjacentStrings1047 {

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int j = 0;
        if (s.length() == 1) return s;
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (sb.length() == 0 || s.charAt(i) != sb.charAt(j)) {
                sb.append(s.charAt(i));
                j++;
            } else {
                sb.delete(j, j + 1);
                j--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(removeDuplicates("a"));
//        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}
