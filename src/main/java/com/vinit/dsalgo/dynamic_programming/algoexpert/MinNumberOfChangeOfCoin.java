package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;

public class MinNumberOfChangeOfCoin {

//     O (nlogn) Time
//    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
//        int min = -1;
//        int[] res = new int[n + 1];
//        Arrays.fill(res, Integer.MAX_VALUE);
//        Arrays.sort(denoms);
//        res[0] = 0;
//        for (int i = 1; i < n + 1; i++) {
//            System.out.println("i: " + i + ", d[0]: " + denoms[0] + ", res: " + res[i]);
//            if (i >= denoms[0] && res[i] > i) {
//                System.out.println("res[i - 1]: " + res[i - 1]);
//                res[i] = i - res[i - 1];
//                System.out.println("res[i]: " + res[i]);
//            }
//        }
//        return res[n-1];
//    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int min = -1;
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        Arrays.sort(denoms);
        res[0] = 0;
        for (Integer d : denoms) {
            System.out.println("denom: " + d);
            for (int i = 0; i < n; i++) {
                System.out.println("i: " + i);
                if (i >= d) {
                    System.out.println("res[i]: " + res[i] + ", res[i - d] + 1: " + (res[i - d] + 1) +
                            ", min: " + Math.min(res[i], res[i - d] + 1));
                    res[i] = Math.min(res[i], res[i - d] + 1);
                    System.out.println("res[i]: " + res[i]);
                }
            }
        }
        return res[n] > (n * 2) ? -1 : res[n];
    }

    public static void main(String args[]) {
        int[] denoms = {3,4,5};
        System.out.println(minNumberOfCoinsForChange(9, denoms));
    }
}
