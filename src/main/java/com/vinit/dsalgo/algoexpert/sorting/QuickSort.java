package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        // Write your code here.
        int low = 0;
        int high = array.length - 1;
        sort(array, low, high);
        return array;
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            System.out.println("pivot: " + pivot);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(quickSort(array)));
    }
}
