package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;

public class MinNumberOfChangeOfCoin {

//     O (nlogn) Time
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        Arrays.sort(denoms);
        res[0] = 0;
        int toCompare = 0;
        for (int d : denoms) {
            for (int i = 0; i < n + 1; i++) {
                if (i >= d) {
                    if (res[i - d] == Integer.MAX_VALUE) {
                        toCompare = res[i - d];
                    } else toCompare = res[ i - d ] + 1;
                    res[i] = Math.min(res[i], toCompare);
                }
            }
//            System.out.println(d + " - " + Arrays.toString(res));
        }
        return res[n] == Integer.MAX_VALUE ? -1 : res[n];
    }

//    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
//        int min = -1;
//        int[] res = new int[n + 1];
//        Arrays.fill(res, Integer.MAX_VALUE);
//        Arrays.sort(denoms);
//        res[0] = 0;
//        for (Integer d : denoms) {
//            System.out.println("denom: " + d);
//            for (int i = 0; i < n; i++) {
//                System.out.println("i: " + i);
//                if (i >= d) {
//                    System.out.println("res[i]: " + res[i] + ", res[i - d] + 1: " + (res[i - d] + 1) +
//                            ", min: " + Math.min(res[i], res[i - d] + 1));
//                    res[i] = Math.min(res[i], res[i - d] + 1);
//                    System.out.println("res[i]: " + res[i]);
//                }
//            }
//        }
//        return res[n] > (n * 2) ? -1 : res[n];
//    }

    public static void main(String args[]) {
        int[] denoms = {3,4,5};
//        int[] denoms = {1,5,10};
        int n = 9;
        System.out.println(minNumberOfCoinsForChange(n, denoms));
    }
}
