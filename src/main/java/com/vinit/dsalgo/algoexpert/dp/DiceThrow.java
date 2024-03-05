package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class DiceThrow {

    public static int diceThrows(int numDice, int numSides, int target) {
        // Write your code here.
        int[][] dp = new int[numDice + 1][target + 1];
        dp[0][0] = 1;
        for (int currNumDice = 1; currNumDice <= numDice; currNumDice++ ) {
            for (int currTarget = 0; currTarget <= target; currTarget++) {
                int maxSumTillCurrTarget = 0;
                for (int currNumSide = 1; currNumSide <= Math.min(currTarget, numSides); currNumSide++) {
                    maxSumTillCurrTarget += dp[currNumDice - 1][currTarget - currNumSide];
                }
                dp[currNumDice][currTarget] = maxSumTillCurrTarget;
            }
        }
        return dp[numDice][target];
    }

    public static void main(String[] args) {
        System.out.println(diceThrows(2, 6, 7));
    }
}
