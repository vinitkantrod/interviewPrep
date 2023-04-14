package com.vinit.dsalgo.strings.leetcode;

public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
//        s = s.toLowerCase()
//                .replace(":", "")
//                .replace("@", "")
//                .replace("$", "")
//                .replace(",", "")
//                .replace("#", "")
//                .replace("!", "")
//                .replace("%", "")
//                .replace("^", "")
//                .replace("&", "")
//                .replace("*", "")
//                .replace("(", "")
//                .replace(")", "")
//                .replace("-", "")
//                .replace("+", "")
//                .replace("{", "")
//                .replace("}", "")
//                .replace("[", "")
//                .replace("]", "")
//                .replace("/", "")
//                .replace("<", "")
//                .replace(" ", "")
//                .replace(">", "");
//        int n = s.length() - 1;
//        int i = 0;
//        System.out.println(s);
//        while (i < n) {
//            if (s.charAt(i) != s.charAt(n)) return false;
//            i++;
//            n--;
//        }
//        return true;

        // LC code
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
