package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
//        System.out.println(Arrays.toString(arrayOne));
//        System.out.println(Arrays.toString(arrayTwo));
        int i = 0;
        int j = 0;
        int smallestDiff = Integer.MAX_VALUE;
        int num1 = arrayOne[0];
        int num2 = arrayTwo[0];
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (i > arrayOne.length || j > arrayTwo.length) break;
//            System.out.println("i: " + i + ", j: " + j);
            if (Math.abs(arrayOne[i] - arrayTwo[j]) < smallestDiff) {
                smallestDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
//                System.out.println("smallestDiff: " + smallestDiff);
                num1 = arrayOne[i];
                num2 = arrayTwo[j];
            }
            if (arrayOne[i] > arrayTwo[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] ints = {num1, num2};
        return ints;
    }

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        System.out.println(Arrays.toString(smallestDifference(arrayOne, arrayTwo)));
    }
}
