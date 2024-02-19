package com.vinit.interviews.pocketfm;

/**
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: s = "aba" "aaa"
 * Output: false
 * Example 3:
 *  "abcde"
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 */
public class pocketfmOne {

    public static Boolean stringConstruction(String s) {
        if (s.isEmpty()) return true;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n - 1) {
            String sub = s.substring(left, right + 1);
            int subLength = sub.length();
            StringBuilder sb = new StringBuilder();
            sb.append(sub);
            // Taking care for lowerCase and UpperCase strings too
            while (subLength < n && s.toLowerCase().startsWith(sb.toString().toLowerCase())) {
                sb.append(sub);
                subLength += subLength;
                if (sb.toString().equalsIgnoreCase(s)) {
                    return true;
                }
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("abab: " + stringConstruction("abab"));
        System.out.println("aaa: " + stringConstruction("aaa"));
        System.out.println("aca: " + stringConstruction("aca"));
        System.out.println("abcabcabcabc: " + stringConstruction("abcabcabcabc"));
        System.out.println("abccba: " + stringConstruction("abccba"));
        System.out.println("abAB: " + stringConstruction("abAB"));
    }
}
