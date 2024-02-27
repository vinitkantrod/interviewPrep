package com.vinit.dsalgo.algoexpert.searching;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        return search(array, 0, array.length, target);
    }

    private static int search(int[] arr, int low, int high, int target) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (target < arr[mid])
                return search(arr, low, mid - 1, target);
            else
                return search(arr, mid + 1, high, target);
        }
        return -1;
    }
}
