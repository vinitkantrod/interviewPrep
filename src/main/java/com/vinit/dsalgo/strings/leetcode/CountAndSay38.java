package com.vinit.dsalgo.strings.leetcode;

public class CountAndSay38 {

    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String k = String.valueOf(res);
            int j = 0;
            char prevVal = k.charAt(0);
            int count = 0;
            while (j < k.length()) {
                if (k.charAt(j) == prevVal) {
                    j++;
                    count++;
                } else {
                    sb.append(String.valueOf(count) + String.valueOf(prevVal));
                    prevVal = k.charAt(j);
                    count = 1;
                    j++;
                }
            }
            sb.append(String.valueOf(count) + prevVal);
            res = sb.toString();
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
