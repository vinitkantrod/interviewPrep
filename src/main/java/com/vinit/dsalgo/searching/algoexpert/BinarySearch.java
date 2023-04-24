package com.vinit.dsalgo.searching.algoexpert;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        // O(logN) space complexity
        return bs(array, 0, array.length - 1, target);
    }

    public static int bs(int[] array, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        System.out.println("mid: " + array[mid]);
        if (array[mid] == target) return mid;
        if (target < array[mid])
            return bs (array, start, mid - 1, target);
        else
            return bs(array, mid + 1, end, target);
    }

    public static void main(String[] args) {
        int[] arr = {0,1,21,33,45,45,61,71,72,73};
        System.out.println(binarySearch(arr, 33));
    }
}
