package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
       for (int pass = array.length; pass > 0; pass--) {
           for (int i = 0; i < pass - 1; i++) {
               if (array[i] > array[i+1]) {
                   swap(array, i, i + 1);
               }
           }
       }
       return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }
    public static void main(String args[]) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
