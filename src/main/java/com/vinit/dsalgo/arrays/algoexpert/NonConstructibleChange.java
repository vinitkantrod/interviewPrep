package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int constructibleCoins = 0;
        for (int coin : coins) {
            if (coin > constructibleCoins + 1) return constructibleCoins + 1;
            constructibleCoins += coin;
        }
        return constructibleCoins + 1;
    }

    public static void main(String args[]) {
        int[] n = {5,7,1,1,2,3,22};
        System.out.println(nonConstructibleChange(n));
    }
}
