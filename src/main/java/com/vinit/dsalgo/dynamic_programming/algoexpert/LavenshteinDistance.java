package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;

public class LavenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] matrix;
        matrix = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str1.length() + 1; j++){
                matrix[i][j] = j;
            }
            matrix[i][0] = i;
        }
        matrix[0][0] = 0;
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j - 1];
                else
                    matrix[i][j] = 1 + Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]));
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return matrix[str2.length()][str1.length()];
    }

    public static void main(String args[]) {
        levenshteinDistance("abc", "yabd");
    }
}
