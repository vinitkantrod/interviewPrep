package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class MinimumNoOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        if (n == 0) return 0;
        int[] minChange = new int[n + 1];
        Arrays.fill(minChange, Integer.MAX_VALUE);
        minChange[0] = 0;
        Arrays.sort(denoms);
        for (int coin : denoms) {
            int toCompare = 0;
            for (int i = 1; i <= n; i++)
                if (i >= coin) {
                    if (minChange[i - coin] == Integer.MAX_VALUE) toCompare = minChange[i - coin];
                    else toCompare = Math.min(minChange[i], 1 + minChange[i - coin]);
                    minChange[i] = Math.min(minChange[i], toCompare);
                }
        }
        return minChange[n] == Integer.MAX_VALUE ? -1 : minChange[n];
    }

    public static void main(String[] args) {
//        int[] d = new int[]{1,5,10};
        int[] d = new int[]{3,5};
        System.out.println(minNumberOfCoinsForChange(9,d));
    }
}
