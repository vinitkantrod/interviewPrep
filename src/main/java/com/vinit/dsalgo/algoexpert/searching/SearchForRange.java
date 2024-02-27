package com.vinit.dsalgo.algoexpert.searching;

import java.util.Arrays;

public class SearchForRange {

    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        int[] result = new int[]{-1, -1};
        search(array, target, 0, array.length - 1, result, true);
        search(array, target, 0, array.length - 1, result, false);
        return result;
    }

    private static void search(int[] arr, int target, int left, int right, int[] result, boolean goLeft) {
        if (left > right) return;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < arr[mid]) right = mid - 1;
            else if (target > arr[mid]) left = mid + 1;
            else {
                if (goLeft) {
                    if (mid == 0 || arr[mid - 1] != target) {
                        result[0] = mid;
                        return;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == arr.length - 1 || arr[mid + 1] != target) {
                        result[1] = mid;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,21,33,45,45,45,45,45,45,61,71,73};
        System.out.println(Arrays.toString(searchForRange(a, 21)));
    }
}
