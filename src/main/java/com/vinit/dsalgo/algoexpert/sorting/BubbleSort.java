package com.vinit.dsalgo.algoexpert.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        int passes;
        int len = array.length;
        for (passes = len - 1; passes >= 0; passes--) {
            for (int i = 0; i < passes; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] b = new int[]{8,5,2,9,5,6,3};

    }
}
