package com.vinit.dsalgo.arrays.algoexpert;

import java.util.*;

public class FourNumberSum {

    public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
        ArrayList<Integer[]> quadruples = new ArrayList<>();
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];

                int difference = targetSum - currentSum;
                if (allPairSums.containsKey(difference)) {
                    for (Integer[] pairs : allPairSums.get(difference)) {
                        Integer[] newQuadruples = {pairs[0], pairs[1], array[i], array[j]};
                        quadruples.add(newQuadruples);
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int currentSum = array[k] + array[i];
                Integer[] pair = {array[k], array[i]};
                if (!allPairSums.containsKey(currentSum)) {
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(pair);
                    allPairSums.put(currentSum, pairs);
                } else {
                    allPairSums.get(currentSum).add(pair);
                }
            }
        }
        return quadruples;
    }

    public static void main(String[] args) {
        int[] arr = {7,6,4,-1,1,2};
        fourNumberSum(arr, 16);
    }
}
