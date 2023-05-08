package com.vinit.dsalgo.arrays.leetcode;

public class LongerContinousSegmentOfOnesAndZero1869 {

    public static boolean checkZeroOnes(String s) {
        int maxOnesLength = 0;
        int maxZerosLength = 0;
        int oneL = 0;
        int zeroL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneL++;
                zeroL = 0;
                maxOnesLength = Math.max(oneL, maxOnesLength);
            } else {
                oneL = 0;
                zeroL++;
                maxZerosLength = Math.max(zeroL, maxZerosLength);
            }
        }
        System.out.println(maxOnesLength);
        System.out.println(maxZerosLength);
        return maxOnesLength > maxZerosLength;
    }

    public static void main(String[] args) {
        System.out.println(checkZeroOnes("110100010"));
        System.out.println(checkZeroOnes("111000"));
        System.out.println(checkZeroOnes("1101"));
    }
}
