package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class HeapSort {
    public static int[] heapSort(int[] array) {
        // Write your code here.
        int N = array.length;
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(array, N, i);
        }
        System.out.println("Original Heap: " + Arrays.toString(array));

        for (int i = N - 1; i >= 0; i--) {
            System.out.println("...before swapping: " + Arrays.toString(array));
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            System.out.println("...After swapping: " + Arrays.toString(array));
            heapify(array, i, 0);

        }
        return array;
    }

    public static void heapify(int[] array, int N, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < N && array[left] > array[largest]) {
            largest = left;
        }
        if (right < N && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest]= temp;
            heapify(array, N, largest);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(heapSort(a)));
    }
}
