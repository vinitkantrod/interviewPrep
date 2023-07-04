package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquare279 {

    public static int numSquares(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        List<Integer> coins = new ArrayList<>();
        int x = 1;
        int y = x * x;
        while (y <= n) {
            coins.add(y);
            x++;
            y = x * x;
        }
        System.out.println(Arrays.asList(coins));
        arr[0] = 0;
        arr[1] = 1;
        for (int i : coins) {
            for (int j = 2; j <= n; j++) {
                if (j >= i) {
                    arr[j] = Math.min(arr[j], arr[j - i] + 1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr[n];
    }
    public static void main(String[] args) {
        System.out.println(numSquares(4));
    }
}
