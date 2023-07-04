package com.vinit.dsalgo.dynamic_programming.leetcode;

import javax.swing.plaf.SpinnerUI;
import java.util.Arrays;

public class CoinChangeTwo518 {
    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for (int c : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= c) {
                    arr[i] = arr[i] + arr[i - c];
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr[amount];
    }
    public static void main(String[] args) {
        int[] c = {1,2,5};
        System.out.println(change(5, c));
    }
}
