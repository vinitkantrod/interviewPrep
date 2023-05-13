package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.Arrays;

public class SolvingQuestionWithBrainPower2140 {

    public static long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        long maxPoint = 0;
        int maxIndex = 0;
        int n = questions.length - 1;
        for (int i = n; i >= 0; i--) {
            int[] pair = questions[i];
            long currMaxPoint = 0;
//            if (pair[0] > maxPoint) {
//                maxPoint = pair[0];
//                maxIndex = pair[1];
//            }
            if ((i + pair[1] + 1) <= n) {
                currMaxPoint = pair[0] + dp[i + pair[1] + 1];
            } else if (pair[0] > maxPoint) {
                currMaxPoint = pair[0];
            } else {
                currMaxPoint = maxPoint;
            }
            currMaxPoint = Math.max(currMaxPoint, maxPoint);
            maxPoint = currMaxPoint;
            System.out.println(currMaxPoint);
            dp[i] = currMaxPoint;
//            if (currMaxPoint > maxPoint) maxPoint = currMaxPoint;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
//        int[][] q = {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}};
//        int[][] q = {{3,2}, {4,3}, {4,4}, {2,5}};
        int[][] q = {{3,0}, {4,0}, {4,1}, {2,0}};
        System.out.println(mostPoints(q));
    }
}
