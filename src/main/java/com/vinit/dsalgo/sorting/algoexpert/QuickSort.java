package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        quick(array, 0, array.length - 1);
        return array;
    }

    public static void quick(int[] array, int left, int right) {
        if (left < right) {
            System.out.println(Arrays.toString(array));
            int partition = partition(array, left, right);
            quick(array, left, partition - 1);
            quick(array, partition + 1, right);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            System.out.println(i +","+j);
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                System.out.println("swapping: " + Arrays.toString(array));
            }
        }
        swap(array, i + 1, right);
        System.out.println("after swapping: " + Arrays.toString(array));
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    public static void main(String args[]) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        System.out.println(Arrays.toString(quickSort(array)));
    }
}
