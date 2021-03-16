package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        String[][] matrix = new String[str1.length() + 1][ str2.length() + 1];
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                matrix[i][j] = "";
            }
        }
        for (int i = 1; i < str1.length() + 1; i++) {
            System.out.println("i: " + i);
            for (int j = 1; j < str2.length() + 1; j++) {
                System.out.println("j: " + j);
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + String.valueOf(str2.charAt(j - 1));
                } else {
                    matrix[i][j] = matrix[i - 1][j].length() > matrix[i][j - 1].length()
                            ? matrix[i - 1][j]
                            : matrix[i][j - 1];
                }
            }
        }
        String finalString = matrix[str1.length()][str2.length()];
        System.out.println("finalString: " + finalString);
        for (int i = 0; i < finalString.length(); i++) {
            res.add(finalString.charAt(i));
        }
        return res;
    }
    public static void main(String args[]) {
        System.out.println(longestCommonSubsequence("ZXVVYZW", "XKYKZPW"));
    }
}
