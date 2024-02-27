package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class InsertionSortReverse {

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int valueIdx = i;
            int j = i - 1;
            while (j >= 0 && array[j] < array[valueIdx]) {
                int temp = array[j];
                array[j] = array[valueIdx];
                array[valueIdx] = temp;
                j--;
                valueIdx--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] b = new int[]{8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(insertionSort(b)));
    }
}
