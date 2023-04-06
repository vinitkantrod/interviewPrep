package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.*;

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

//    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
//        int[] maxSumArray = new int[array.length];
//        int[] sequence = new int[array.length];
//        System.out.println(Arrays.toString(array));
//        Arrays.fill(maxSumArray, -1);
//        Arrays.fill(sequence, -1);
//        int maxSum = 0;
//        maxSumArray[0] = array[0];
//        sequence[0] = -1;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i - 1] < array[i]) {
//                maxSumArray[i] = maxSumArray[i-1] + array[i];
//                sequence[i] = i - 1;
//            } else {
//                for (int j = i - 1; j >= 0; j--) {
//                    if (array[j] < array[i]) {
//                        maxSumArray[i] = maxSumArray[j] + array[i];
//                        sequence[i] = j;
//                    }
//                }
//            }
//            System.out.println(Arrays.toString(maxSumArray) + " - " + Arrays.toString(sequence));
//        }
//        int maxSumIndex = 0;
//        for (int i =0; i < array.length; i++) {
//            if (maxSumArray[i] > maxSum) {
//                maxSum = maxSumArray[i];
//                maxSumIndex = i;
//            }
//        }
//        System.out.println(Arrays.toString(sequence));
//        System.out.println(maxSum + " - " + maxSumIndex);
//
//        List<Integer> s = new ArrayList<>();
//        while ( maxSumIndex >= 0) {
//            s.add(0, array[maxSumIndex]);
//            maxSumIndex = sequence[maxSumIndex];
//        }
//        System.out.println(s + "___" + Arrays.asList(s));
//        List<List<Integer>> response = new ArrayList<>();
//        response.add(new ArrayList<>(Arrays.asList(maxSum)));
//        response.add(s);
//        return response;
//    }
    public static void main(String args[]) {
//        int[] arr = {10,70, 20, 30, 50, 11, 30};
        int[] arr = {-1, 1};
        maxSumIncreasingSubsequence(arr);
    }
}
