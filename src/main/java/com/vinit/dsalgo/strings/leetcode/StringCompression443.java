package com.vinit.dsalgo.strings.leetcode;

public class StringCompression443 {
    public static int compress(char[] chars) {
//        StringBuilder sb = new StringBuilder();
//        int i = 1;
//        char currChar = chars[0];
//        sb.append(currChar);
//        int count = 1;
//        while (i < chars.length) {
//            while (i < chars.length && chars[i] == currChar) {
//                count++;
//                i++;
//            }
//            sb.append("" + count);
//            System.out.println(sb.toString());
//            if (i == chars.length) break;
//            currChar = chars[i];
//            count = 1;
//            sb.append(currChar);
//            i++;
//            System.out.println(sb.toString());
//        }
//        sb.append("" + count);
//        return sb.toString().length();
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(compress("abbbbbbbbbbbb".toCharArray()));
    }
}
