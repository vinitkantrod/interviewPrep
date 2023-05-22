package com.vinit.dsalgo.sorting.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapSort {

    public static int[] heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            System.out.println("Finished first loop: " + Arrays.toString(array));
        }
        System.out.println("Arrays: " + Arrays.toString(array));
        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        System.out.println("largest: " + largest + ", l: " + l + ", r: " + r);
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        System.out.println("largest: " + largest + ", l: " + l + ", r: " + r);
        if (largest != i) {
            System.out.println("swaping...");
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            System.out.println("swapped: " + Arrays.toString(array));
            heapify(array, n, largest);
        }
        System.out.println("done for " + i + ", largest: " + largest + ", arr: " + Arrays.toString(array));

    }

    public static void main(String args[]) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(heapSort(arr)));
    }
}
