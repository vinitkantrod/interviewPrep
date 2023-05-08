package com.vinit.dsalgo.leetcode150MostAsked.array;

public class FindTheIndexOfFirstOccuranceOfString28 {

    public static int strStr(String haystack, String needle) {
        // LC CODE
        // Editorial
        // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/editorial/?envType=study-plan-v2&id=top-interview-150

//        return haystack.indexOf(needle);

        // Sliding Window solution
        int m = needle.length();
        int n = haystack.length();

        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }
                if (i == m - 1) {
                    return windowStart;
                }
            }
        }

        return -1;

//        for (int i = 0; i < haystack.length(); i++) {
//            System.out.println("i: " + i + ", j: "+ j);
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                if (idxFound == -1) idxFound = i;
//                if (j == needle.length() - 1) return idxFound;
//                j++;
//            } else {
//                idxFound = -1;
//                j = 0;
//            }
//        }
//        return (j == needle.length() ) ? idxFound : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("leetcode", "e"));
        System.out.println(strStr("mississippi", "issip"));
    }
}
