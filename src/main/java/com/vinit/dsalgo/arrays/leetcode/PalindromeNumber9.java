package com.vinit.dsalgo.arrays.leetcode;

public class PalindromeNumber9 {

    public static boolean isPalindrome(int x) {
//        String s1 = Integer.toString(x);
//        StringBuilder sb = new StringBuilder(s1);
//        String s2 = sb.reverse().toString();
//        int i = 0;
//        while (i < s1.length()) {
//            if (s1.charAt(i) != s2.charAt(i)) return false;
//            i++;
//        }
//        return true;

        // LC code
        String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        for (int i=0; i<n/2; i++) {
            // We check whether the elements at the same distance from
            // beginning and from ending are same, if not we return false
            if (s.charAt(i) != s.charAt(n-i-1)) return false;
        }

        // if no flaws are found we return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
    }
}
