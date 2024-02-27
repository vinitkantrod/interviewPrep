package com.vinit.dsalgo.algoexpert.searching;

import java.util.Arrays;

public class MedianOfSortedArray {
    public static float medianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] a = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0;
        int k = 0;
        while ( i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) a[k++] = arrayOne[i++];
            else a[k++] = arrayTwo[j++];
        }
        while (i < arrayOne.length) a[k++] = arrayOne[i++];
        while (j < arrayTwo.length) a[k++] = arrayTwo[j++];
        System.out.println(Arrays.toString(a));
        int left = 0;
        int right = a.length - 1;
        return 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,5};
        int[] b = new int[]{2,3,6,7};
        System.out.println(medianOfTwoSortedArrays(a, b));
    }

}
