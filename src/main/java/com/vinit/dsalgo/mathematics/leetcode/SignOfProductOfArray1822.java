package com.vinit.dsalgo.mathematics.leetcode;

public class SignOfProductOfArray1822 {

    public static int arraySign(int[] nums) {
        int product = 1;
        for (int i : nums) {
            if (i < 0) product *= -1;
            else if (i == 0) product *= 0;
            else product *= 1;
            System.out.println(i + " - " + product);
        }
        return product > 0 ? 1 : product == 0 ? 0 : -1;
    }

    public static void main(String[] args) {
        int[] n = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(arraySign(n));
    }
}
