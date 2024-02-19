package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class CountInversion {

    public static int countInversions(int[] array) {
        // Write your code here.
        return sortAndCount(array, 0, array.length - 1);
    }

    private static int sortAndCount(int[] array, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += sortAndCount(array, low, mid);
            count += sortAndCount(array, mid + 1, high);
            count += mergeAndCount(array, low, mid, high);
        }
        return count;
    }

    private static int mergeAndCount(int[] array, int low, int mid, int high) {
        int[] n1 = Arrays.copyOfRange(array, low, mid + 1);
        int[] n2 = Arrays.copyOfRange(array, mid + 1, high + 1);
        int i = 0, j =0;
        int k = low;
        int swap = 0;
        System.out.println(Arrays.toString(n1) + " | " + Arrays.toString(n2));
        while (i < n1.length && j < n2.length) {
            if (n1[i] <= n2[j]) array[k++] = n1[i++];
            else {
                array[k++] = n2[j++];
                swap += (mid + 1) - (low + i);
            }
        }
        System.out.println("swaps: " + swap);
        while (i < n1.length) array[k++] = n1[i++];
        while (j < n2.length) array[k++] = n2[j++];
        return swap;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,3,1,9,5,6};
//        int[] a = new int[]{8,4,2,1};
        System.out.println(countInversions(a));
    }
}
