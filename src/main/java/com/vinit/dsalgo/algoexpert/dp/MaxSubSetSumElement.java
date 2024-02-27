package com.vinit.dsalgo.algoexpert.dp;

import java.util.Arrays;

public class MaxSubSetSumElement {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int first = array[0];
        int second = Math.max(array[1], first);
        for (int i = 2; i < array.length; i++) {
            int temp = Math.max(first + array[i], second);
            first = second;
            second = temp;
            System.out.println(first + " - " + second);
        }
        return second;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{75,105,120, 75,90, 135};
        int[] a = new int[]{4,3,5,200,5,3};
        System.out.println(maxSubsetSumNoAdjacent(a));
    }
}
