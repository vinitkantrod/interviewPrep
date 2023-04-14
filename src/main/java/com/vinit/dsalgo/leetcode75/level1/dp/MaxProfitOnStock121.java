package com.vinit.dsalgo.leetcode75.level1.dp;

public class MaxProfitOnStock121 {

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

    public static void main(String[] args) {
//        int[] prices = {4,1,5,2,7};
        int[] prices = {7,6,4,3,10,1};
        System.out.println(maxProfit(prices));
    }
}
