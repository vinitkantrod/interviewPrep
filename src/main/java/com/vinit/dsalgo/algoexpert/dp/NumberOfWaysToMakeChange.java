package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] amount = new int[n + 1];
        Arrays.fill(amount, 0);
        amount[0] = 1;
        for (int coin : denoms) {
            for (int i = 0; i <= n; i++) {
                if (coin <= i) {
                    amount[i] += amount[i - coin];
                }
            }
        }
        return amount[amount.length - 1];
    }

    public static void main(String[] args) {
//        int[] d = new int[]{1,5};
        int[] d = new int[]{2,3,4,7};
        System.out.println(numberOfWaysToMakeChange(0,d));
    }
}
