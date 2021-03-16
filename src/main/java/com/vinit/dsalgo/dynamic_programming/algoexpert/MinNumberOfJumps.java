package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberOfJumps {

    public static int minNumberOfJumps(int[] array) {
        int[] res = new int[array.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] >= i - j) {
                    res[i] = (Math.min(res[j] + 1, res[i]));
                }
            }
        }
        return res[res.length - 1];
    }

    public static void main(String args[]) {
        int[] a = {3,4,2,1,2,3,7,1,1,1,3};
        System.out.println(minNumberOfJumps(a));
    }
}
