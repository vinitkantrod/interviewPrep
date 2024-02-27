package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int x = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = x++;
        x = 0;
        for (int i = 0; i <= m; i++) dp[0][i] = x++;
        print(dp);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
            System.out.println("=========");
            print(dp);
        }
        return dp[str1.length()][str2.length()];
    }

    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) System.out.println(Arrays.toString(dp[i]));
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("biting","mitten"));
    }
}
