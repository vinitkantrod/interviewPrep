package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j >= 1 && array[j] < array[j -1]) {
                swap(array, j , j -1);
                j--;
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String args[]) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
