package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.
        if (coins.length == 0) return 1;
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        int constructibleCoin = 0;
        for (int coin : coins) {
            if (coin > constructibleCoin + 1) return constructibleCoin + 1;
            constructibleCoin += coin;
            System.out.println(constructibleCoin);
        }
        return constructibleCoin + 1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{5,7,1,1,2,3,22};
        System.out.println(nonConstructibleChange(coins));
    }
}
