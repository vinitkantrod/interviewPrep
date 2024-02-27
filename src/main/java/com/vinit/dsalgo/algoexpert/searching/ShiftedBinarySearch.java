package com.vinit.dsalgo.algoexpert.searching;

public class ShiftedBinarySearch {
    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        return search(array, 0, array.length - 1, target);
    }
    private static int search(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[low] <= arr[mid])
                if (target >= arr[low] && arr[mid] > target)
                    return search(arr, low, mid - 1, target);
                else
                    return search(arr, mid + 1, high, target);
            else
                if (target > arr[mid] && target <= arr[high])
                    return search(arr, mid + 1, high, target);
                else
                    return search(arr, low, mid - 1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{45,61,71,72,73,0,1,21,33,37};
        int[] a = new int[]{72,73,0,1,21,33,37,45,61,71};
        System.out.println(shiftedBinarySearch(a, 45));
    }
}
