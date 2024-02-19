package com.vinit.dsalgo.algoexpert.sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        int index = 0;
        while (index < array.length - 1) {
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] < array[index]) {
                    int temp = array[index];
                    array[index] = array[i];
                    array[i] = array[index];
                }
            }
        }
        return array;
    }
}
