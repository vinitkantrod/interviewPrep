package com.vinit.dsalgo.arrays.leetcode;

public class CalculateDigitSumOfString2243 {
    public static String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        // Continue until length of sb is less than or equal to k
        while (sb.length() > k) {
            StringBuilder newString = new StringBuilder();
            int i = 0;

            // Iterate over characters of sb
            while (i < sb.length()) {
                int sum = 0;
                int count = 0;

                // Calculate sum of digits for each group
                while (i < sb.length() && count < k) {
                    sum += sb.charAt(i) - '0';
                    i++;
                    count++;
                }

                newString.append(sum);
            }

            sb = newString; // Update sb with newString
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
    }
}
