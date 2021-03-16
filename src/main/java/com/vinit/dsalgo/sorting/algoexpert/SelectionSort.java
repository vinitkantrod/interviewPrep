package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        int index = 0;
        while (index < array.length) {
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] < array[index]) {
                    swap(array, i, index);
                }
            }
            index++;
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
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
