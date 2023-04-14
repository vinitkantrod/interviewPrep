package com.vinit.dsalgo.arrays.leetcode;

public class RichesTCustomerWealth1672 {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int userWealth = 0;
            for (int j = 0; j < accounts[0].length; j++)
                userWealth += accounts[i][j];
            if (userWealth > maxWealth) maxWealth = userWealth;
        }
        return maxWealth;
    }
    public static void main(String[] args) {
        int[][] accounts= {{1,5}, {3,7}, {3,5}};
        System.out.println(maximumWealth(accounts));
    }
}
