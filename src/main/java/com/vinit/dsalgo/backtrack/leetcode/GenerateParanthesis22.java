package com.vinit.dsalgo.backtrack.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis22 {

    public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        if (n == 0) return output;
        combination(n, "(", 1, output);
        return output;
    }

    public static void combination(int n, String s, int leftPtr, List<String> output) {
        if (leftPtr < 0) return;
        if (s.length() == 2 * n) {
            System.out.print(s);
            if(isValid(s)) {
                System.out.println(" is valid.");
                output.add(s);
            } else {
                System.out.println(" is not valid.");
            }
            return;
        }
        combination(n, s + "(", leftPtr + 1, output);
        if (leftPtr > 0) {
            combination(n, s + ")", leftPtr - 1, output);
        }
    }

    public static Boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else left--;
            if (left < 0) return false;
        }
        return left == 0;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
