package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
        int smallestDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int num1 = arrayOne[0];
        int num2 = arrayTwo[0];
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (i > arrayOne.length || j > arrayTwo.length) break;

            if (Math.abs(arrayOne[i] - arrayTwo[j]) < smallestDiff) {
                smallestDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
                num1 = arrayOne[i];
                num2 = arrayTwo[j];
            }

            if (arrayOne[i] > arrayTwo[j]) {
                j++;
            } else {
                i++;
            }
        }
        int res[] = new int[]{num1, num2};
        return res;
    }

    public static void main(String[] args) {
        int[] aOne = new int[]{-1,5,10,20,28,3};
        int[] aTwo = new int[]{26,134,135,15,17};
        System.out.println(smallestDifference(aOne, aTwo));
    }
}
