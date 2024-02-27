package com.vinit.dsalgo.algoexpert.searching;

import java.util.Arrays;

public class FindThreeLargestSum {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] threeLargest = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array)
            updateLargest(threeLargest, num);
        return threeLargest;
    }
    private static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2])
            shiftAndUpate(threeLargest, num, 2);
        else if (num > threeLargest[1])
            shiftAndUpate(threeLargest, num, 1);
        else if (num > threeLargest[0])
            shiftAndUpate(threeLargest, num, 0);
    }

    private static void shiftAndUpate(int[] array, int num, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (i == idx) array[i] = num;
            else array[i] = array[i + 1];
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,9,5,10,12};
        System.out.println(Arrays.toString(findThreeLargestNumbers(a)));
    }
}
