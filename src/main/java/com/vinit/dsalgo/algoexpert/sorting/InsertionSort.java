package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 1) return array;
        for (int arg1 = 1; arg1 < array.length; arg1++) {
            int valueIdx = arg1;
            int arg2 = arg1 - 1;
            while (arg2 >= 0 && array[valueIdx] < array[arg2]) {
                int temp = array[arg2];
                array[arg2] = array[valueIdx];
                array[valueIdx] = temp;
                arg2--;
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
