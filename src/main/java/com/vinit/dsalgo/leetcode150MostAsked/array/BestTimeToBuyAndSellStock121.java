package com.vinit.dsalgo.leetcode150MostAsked.array;

public class BestTimeToBuyAndSellStock121 {

    public static int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyingPrice) buyingPrice = prices[i];
            else {
                if (prices[i] - buyingPrice > maxProfit) {
                    maxProfit = prices[i] - buyingPrice;
                }
            }
            System.out.println(i + " :: " + buyingPrice + " _ " + maxProfit);
        }
        return maxProfit;
    }
}
