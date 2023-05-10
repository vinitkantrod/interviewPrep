package com.vinit.dsalgo.strings.leetcode;

public class ValidPalindromeTwo680 {

    public static boolean validPalindrome(String s) {
        return validPalindromeString(s, 0, s.length() - 1, false);
    }
    public static boolean validPalindromeString(String s, int start, int end, Boolean isDeleted) {
        if (start > end) return true;
        System.out.println(start + "::" + s.charAt(start) + " == "+ end+ "::" + s.charAt(end) + ", isdeleted: " + isDeleted);
        if (s.charAt(start) == s.charAt(end)) {
                return validPalindromeString(s, start + 1, end - 1, isDeleted);
        } else {
            if (isDeleted) return false;
            return validPalindromeString(s, start +1, end, true) || validPalindromeString(s, start, end - 1, true);
        }
//        Boolean isDeletedChar = false;
//        while (start <= end) {
//            System.out.print(start + "::" + s.charAt(start) + " == "+ end+ "::" + s.charAt(end));
//            if (s.charAt(start) != s.charAt(end)) {
//                System.out.println("<<<< mismatch found >>>>");
//                if (!isDeletedChar) {
//                    if (s.charAt(start + 1) == s.charAt(end)) {
//                        start++;
//                        System.out.println("new start value: "+start);
//                    } else if (s.charAt(start) == s.charAt(end - 1)) {
//                        end--;
//                        System.out.println("new end valur: "+ end);
//                    } else {
//                        return false;
//                    }
//                    isDeletedChar = true;
//                } else {
//                    return false;
//                }
//            }
//            start++;
//            end--;
//            System.out.println();
//        }
//        return true;
    }

    public static void main(String[] args) {
        System.out.println("aba: " + validPalindrome("aba"));
        System.out.println("abc: " + validPalindrome("abc"));
        System.out.println("abca: " + validPalindrome("abca"));
        System.out.println("aaabbb: " + validPalindrome("aaabbb"));
        System.out.println("aaaab: " + validPalindrome("aaaab"));
        System.out.println("abczcba: " + validPalindrome("abczcba"));
        System.out.println("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga: " +
                validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
