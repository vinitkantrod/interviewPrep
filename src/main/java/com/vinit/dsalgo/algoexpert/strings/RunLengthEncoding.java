package com.vinit.dsalgo.algoexpert.strings;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string) {
        // Write your code here.
        int strLen = string.length();
        final int MAX_LEN = 9;
        if (strLen == 1) return String.valueOf(1) + string;
        Character lastCharacter = Character.MIN_VALUE;
        int lastCharCount = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < strLen) {
            if (lastCharacter == Character.MIN_VALUE ||
            string.charAt(i) == lastCharacter) {
                lastCharacter = string.charAt(i);
                lastCharCount++;
                if (lastCharCount > MAX_LEN ) {
                    sb.append(String.valueOf(MAX_LEN) + String.valueOf(lastCharacter));
                    lastCharCount = 1;
                }
            } else {
                sb.append(String.valueOf(lastCharCount) + String.valueOf(lastCharacter));
                lastCharCount = 1;
                lastCharacter = string.charAt(i);
            }
            i++;
        }
        sb.append(String.valueOf(lastCharCount) + String.valueOf(lastCharacter));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCDD"));
        System.out.println(runLengthEncoding("AAAAAAAAAAAAAAAAA"));
        System.out.println(runLengthEncoding("ABCDEF"));
        System.out.println(runLengthEncoding("A"));
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCDDAAAAABBBCCC"));
    }
}
