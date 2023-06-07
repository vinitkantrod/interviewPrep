package com.vinit.dsalgo.strings.leetcode;

import java.util.Arrays;

public class ArithematicProgressionFromSequence1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr.length == 2) return true;
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (diff != Math.abs(arr[i] - arr[i + 1])) return false;
        }
        return true;
    }
}
