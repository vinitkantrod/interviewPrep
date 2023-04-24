package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

//    public static void main(String[] args) {
//        int[] arr = {8,5,2,9,5,6,3};
//        System.out.println(Arrays.toString(insertionSort(arr)));
//    }
}
