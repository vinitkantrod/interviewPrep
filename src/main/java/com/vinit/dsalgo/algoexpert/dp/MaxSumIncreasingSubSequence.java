package com.vinit.dsalgo.algoexpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubSequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
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
        System.out.println(Arrays.toString(sequence));
        System.out.println(Arrays.toString(sum));
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        result.get(0).add(sum[maxSumIdx]);
        int currentIdx=  maxSumIdx;
        while (currentIdx != Integer.MIN_VALUE ) {
            result.get(1).add(0, array[currentIdx]);
            currentIdx = sequence[currentIdx];
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{10,70,20,30,50,11,30};
        int[] a = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(maxSumIncreasingSubsequence(a));
    }
}
