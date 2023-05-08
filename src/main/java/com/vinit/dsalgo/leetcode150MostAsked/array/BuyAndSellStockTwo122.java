package com.vinit.dsalgo.leetcode150MostAsked.array;

public class BuyAndSellStockTwo122 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        Boolean hasShare = false;
        for (int i = 0; i < n; i++) {
            if (hasShare) {
                if (prices[i] < buyingPrice) {
                    buyingPrice = prices[i];
                } else {
                    if ((i + 1) < n && prices[i + 1] > prices[i]) {
                        continue;
                    }
                    maxProfit += prices[i] - buyingPrice;
                    hasShare = false;
                    buyingPrice = Integer.MAX_VALUE;
                }
            } else {
                if (prices[i] < buyingPrice) {
                    hasShare = true;
                    buyingPrice = prices[i];
                }
            }
             System.out.println(i + " :: " + buyingPrice + " _ " + maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] p = {7,1,5,3,6,4};
        int[] p = {1,2,3,4,5};
//        int[] p = {7,6,4,3,2,1};
        System.out.println(maxProfit(p));
    }
}
