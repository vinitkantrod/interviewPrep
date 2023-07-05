package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class FindGCDOfArray1979 {

    private static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        System.out.println(min + " - " + max);
        return gcd(max, min);
    }
    public static void main(String[] args) {
        int[] n = {10,6,9};
        System.out.println(findGCD(n));
    }
}
