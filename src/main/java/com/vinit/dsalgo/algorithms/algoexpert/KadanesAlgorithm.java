package com.vinit.dsalgo.algorithms.algoexpert;

import java.util.Map;

public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        if (array.length == 1) return array[0];
        int maxSum = array[0];
        int lastIndexMaxSum = maxSum;
        for (int i = 1; i < array.length; i++) {
            int maxSumEndingHere = Math.max(array[i], lastIndexMaxSum + array[i]);
//            System.out.println("i: " + i + ", value: " + array[i] + ", maxSumEndingHere: " + maxSumEndingHere);
            if (maxSumEndingHere > maxSum) maxSum = maxSumEndingHere;
            lastIndexMaxSum = maxSumEndingHere;
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int[] array = {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
        System.out.println(kadanesAlgorithm(array));
    }
}
