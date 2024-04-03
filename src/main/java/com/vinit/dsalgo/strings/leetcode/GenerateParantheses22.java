package com.vinit.dsalgo.strings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParantheses22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result=  new ArrayList<>();
        recordParantheses(0, 0, n, "", result);
        return result;
    }

    private static void recordParantheses(int open, int closed, int n, String str, List<String> result) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (open < n) recordParantheses(open + 1, closed, n, str + "(", result);
        if (closed < open) recordParantheses(open, closed + 1, n, str + ")", result);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.asList(generateParenthesis(3)));
    }
}
