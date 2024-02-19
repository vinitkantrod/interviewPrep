package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int K = 100;
        int[] expected = new int[(2 * K) + 1];
        for (int i = 0; i < heights.length; i++) expected[heights[i] + K]++;
        int count = 0;
        int[] sorted = new int[heights.length];
        int k = 0;
        for (int i = 0; i < expected.length; i++) {
            while (expected[i] > 0 ) {
                sorted[k++] = i - K;
                expected[i]--;
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != heights[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,4,2,1,3};
        System.out.println(heightChecker(a));
    }
}
