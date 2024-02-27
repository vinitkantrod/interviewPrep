package com.vinit.dsalgo.algoexpert.searching;

public class QuickSelect {

    public static int quickselect(int[] array, int k) {
        // Write your code here.
        int position = k - 1;
        return quicksort(array, 0, array.length - 1, position);
    }

    private static int quicksort(int[] array, int left, int right, int position) {
        while (true) {
            int pivot = left;
            int startIdx = left + 1;
            int endIdx = right;
            while (startIdx <= endIdx) {
                if (array[startIdx] >= array[pivot] && array[endIdx] < array[pivot]) {
                    swap(array, startIdx, endIdx);
                }
                if (array[startIdx] <= array[pivot]) startIdx++;
                if (array[endIdx] >= array[pivot]) endIdx--;
            }
            swap(array, pivot, endIdx);
            if (endIdx == position)
                return array[endIdx];
            else if (endIdx < position)
                left = endIdx + 1;
            else
                right = endIdx - 1;
        }
    }
    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
