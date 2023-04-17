package com.vinit.dsalgo.recursion.algoexpert;

public class Fibonacci {

    public static int getNthFib(int n) {
        // Write your code here.
        if (n == 1) return 0;
        if (n == 2) return 1;
        int f0 = 0;
        int f1 = 1;
        int newVal = 0;
        for (int i = 3; i <= n; i++) {
            newVal = f0 + f1;
            f0 = f1;
            f1 = newVal;
        }
        return newVal;
    }
}
