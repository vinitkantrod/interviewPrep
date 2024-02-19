package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        // Write your code here.
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] n1 = Arrays.copyOfRange(array, low, mid + 1);
        int[] n2 = Arrays.copyOfRange(array, mid + 1, high + 1);
        int k = low;
        int i = 0, j = 0;
        while (i < n1.length && j < n2.length) {
            if (n1[i] <= n2[j]) array[k++] = n1[i++];
            else array[k++] = n2[j++];
        }
        while (i < n1.length) array[k++] = n1[i++];
        while (j < n2.length) array[k++] = n2[j++];
    }

    public static void main(String[] args) {
        int[] n = new int[]{8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(mergeSort(n)));
    }
}
