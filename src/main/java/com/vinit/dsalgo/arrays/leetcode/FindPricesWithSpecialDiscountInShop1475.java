package com.vinit.dsalgo.arrays.leetcode;

public class FindPricesWithSpecialDiscountInShop1475 {

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int originalPrice = prices[i];
            int discountAmount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= originalPrice) {
                    discountAmount = prices[j];
                    break;
                }
            }
            result[i] = originalPrice - discountAmount;
        }
        return  result;
    }
}
