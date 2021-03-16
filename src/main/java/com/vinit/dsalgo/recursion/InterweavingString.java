package com.vinit.dsalgo.recursion;

public class InterweavingString {

    public static boolean interweavingStrings(String one, String two, String three) {
        if (three.length() != one.length() + two.length()) return false;
        return traverse(one, two, three, 0,0);
    }

    public static Boolean traverse(String one, String two, String three, int i, int j) {
        int k = i + j;
        if (k == three.length()) return true;
        if (i < one.length() && three.charAt(k) == one.charAt(i)) {
            if (traverse(one, two, three, i + 1, j)) return true;
        }
        if (j < two.length() && three.charAt(k) == two.charAt(j)) {
            return (traverse(one, two, three, i, j + 1));
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(interweavingStrings("algoexpert", "your-dream-job", "your-algodream-expertjob"));
    }
}
