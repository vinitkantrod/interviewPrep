package com.vinit.dsalgo.algoexpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        // Write your code here.
        int[] sequence = new int[array.length];
        Arrays.fill(sequence, Integer.MIN_VALUE);
        int[] sum = array.clone();
        int maxSumIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int currIdxNum = array[i];
            for (int j = 0; j < i; j++) {
                int jIdxNum = array[j];
                if (jIdxNum < currIdxNum && sum[j] + currIdxNum >= sum[i]) {
                    sum[i] = sum[j] + currIdxNum;
                    sequence[i] = j;
                }
            }
            if (sum[i] > sum[maxSumIdx]) maxSumIdx = i;
        }
        List<Integer> result = new ArrayList<>();
        System.out.println(List.of(sequence));
        int currentIdx=  maxSumIdx;
        while (currentIdx != Integer.MIN_VALUE ) {
            result.add(0, array[currentIdx]);
            currentIdx = sequence[currentIdx];
        }
        return result;
    }
}
