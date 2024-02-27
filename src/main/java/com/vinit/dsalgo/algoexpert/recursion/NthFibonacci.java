package com.vinit.dsalgo.algoexpert.recursion;

public class NthFibonacci {

    public static int getNthFib(int n) {
        if (n == 1 || n == 2) return n - 1;
        else return getNthFib(n - 2) + getNthFib(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }
}
