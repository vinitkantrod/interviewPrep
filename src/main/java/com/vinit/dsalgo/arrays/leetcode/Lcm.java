package com.vinit.dsalgo.arrays.leetcode;

public class Lcm {

    public static void lcmOfNumbers(int x, int y) {
        int gcd = gcd(x, y);
        System.out.println((x * y)/gcd);
    }
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
    public static void main(String[] args) {
        lcmOfNumbers(7,9);
    }
}
