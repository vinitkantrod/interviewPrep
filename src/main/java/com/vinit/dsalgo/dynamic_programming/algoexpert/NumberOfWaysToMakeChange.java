package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] noOfWays = new int[n + 1];
        if (n == 0 ) return 1;
        Arrays.fill(noOfWays, 0);
        noOfWays[0] = 1;
        Arrays.sort(denoms);
        for (int denom : denoms) {
            for (int i = 1; i < n + 1; i++) {
                if (i >= denom) {
                    noOfWays[i] = noOfWays[i] + noOfWays[i - denom];
                }
            }
            System.out.println(denom + " - " + Arrays.toString(noOfWays));
        }
        return noOfWays[n];
    }

    public static void main(String[] args) {
        int n = 10;
//        int[] denoms = {1,5};
        int[] denoms = {1,5,10, 25};
//        int[] denoms = {10,15};
        System.out.println(numberOfWaysToMakeChange(n, denoms));
    }
}
