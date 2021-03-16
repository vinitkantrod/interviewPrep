package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LongestIncreasingSubsequence {

    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        int[] sum = new int[array.length];
        for (int i = 0; i < array.length; i++) sum[i] = 1;
        int[] sequence = new int[array.length];
        for (int i = 0; i < array.length; i++) sequence[i] = Integer.MIN_VALUE;
        int maxSumIndex = 0;
        for (int i = 1; i < array.length; i++) {
            int currentNumber = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (currentNumber > otherNum && sum[i] < sum[j] + 1 ) {
                    sum[i] = sum[j] + 1;
                    sequence[i] = j;
                }
            }
            if (sum[i] >= sum[maxSumIndex]) maxSumIndex = i;
        }
        List<Integer> seq = buildSequence(array, sequence, maxSumIndex);
        return seq;
    }

    public static List<Integer> buildSequence(int[] array, int[] sequence, int currentIndex) {
        List<Integer> sequences = new ArrayList<>();
        while (currentIndex != Integer.MIN_VALUE) {
            sequences.add(array[currentIndex]);
            currentIndex = sequence[currentIndex];
        }
        Collections.sort(sequences);
        return sequences;
    }
    public static void main(String args[]) {
        int[] array = {5,7,-24,12,10,2,3,12,5,6,35};
        System.out.println(Arrays.toString(longestIncreasingSubsequence(array).toArray()));
    }
}
