package com.vinit.dsalgo.strings.algoexpert;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string) {
        if (string.length() == 1) return String.valueOf(1) + string;
        String lastString = "";
        int lastStringCount = 0;
        int i = 0;
        String res = "";
        while (i < string.length()) {
            if (lastString.isEmpty() || String.valueOf(string.charAt(i)).equals(lastString) ) {
                if (lastStringCount < 9) {
                    lastString = String.valueOf(string.charAt(i));
                    lastStringCount++;
                } else {
                    res += String.valueOf(lastStringCount) + lastString;
                    lastStringCount = 1;
                }
            } else if (!String.valueOf(string.charAt(i)).equals(lastString)) {
                res += String.valueOf(lastStringCount) + lastString;
                lastString = String.valueOf(string.charAt(i));
                lastStringCount = 1;
            }
            System.out.println("i: " + i + ", count: " + lastStringCount + ", string: " + String.valueOf(string.charAt(i)) + ", last: " + lastString + " : " + res);
            i++;
        }
        if (i == string.length()) {
            res += lastStringCount + lastString;
        }
        return res;
    }
    public static void main(String args[]) {
        System.out.println(runLengthEncoding(" "));
//        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }
}
