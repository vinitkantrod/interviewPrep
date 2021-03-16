package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sequence = new int[array.length];
        int[] sum = array.clone();
        Arrays.fill(sequence, Integer.MIN_VALUE);
        int maxSumIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && sum[j] + currentNum >= sum[i]) {
                    sum[i] = sum[j] + currentNum;
                    sequence[i] = j;
                }
            }
            if (sum[i] >= sum[maxSumIndex]) maxSumIndex = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(sum[maxSumIndex])));
        List<Integer> seq = buildSequence(array, sequence, maxSumIndex);
        res.add(seq);
        return res;
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
        int[] arr = {10,70, 20, 30, 50, 11, 30};
        maxSumIncreasingSubsequence(arr);
    }
}
