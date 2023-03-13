package com.vinit.dsalgo.arrays.leetcode;

public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int richestCustomer = 0;
        for (int[] customer : accounts) {
            int sum = 0;
            for (int acc = 0; acc < customer.length; acc++) {
                sum += customer[acc];
            }
            if (sum > richestCustomer) {
                richestCustomer = sum;
            }
        }
        return richestCustomer;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(maximumWealth(arr));
    }
}
