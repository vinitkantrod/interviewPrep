package com.vinit.dsalgo.arrays.leetcode;

public class MaximumProductOfTwoElement1464 {

    public int maxProduct(int[] nums) {
        int firstLarge = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for (int i : nums) {
            if (firstLarge < i) {
                secondLarge = firstLarge;
                firstLarge = i;
            } else if (secondLarge < i) {
                secondLarge = i;
            }
        }
        System.out.println(firstLarge + "-" + secondLarge);
        return (firstLarge - 1) * (secondLarge - 1);
    }
}
