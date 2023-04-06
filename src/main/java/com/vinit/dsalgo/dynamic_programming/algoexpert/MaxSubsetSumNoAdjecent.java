package com.vinit.dsalgo.dynamic_programming.algoexpert;

public class MaxSubsetSumNoAdjecent {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) return 0;
        int[] maxArray = new int[array.length];
        if (array.length == 1) return array[0];
        if (array.length == 2) return Math.max(array[0], array[1]);
        maxArray[0] = array[0];
        maxArray[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxArray[i] = Math.max(maxArray[i - 1], maxArray[i - 2] + array[i]);
        }
        return maxArray[maxArray.length - 1];
    }

    public static void main(String[] args) {
//        int[] array = {75, 105, 120, 75, 90, 135};
        int[] array = {4,3,5,200,5,3};
        System.out.println(maxSubsetSumNoAdjacent(array));
    }
}
