package com.vinit.dsalgo.algoexpert.searching;

public class IndexEqualValue {

    public static int indexEqualsValue(int[] array) {
        // Write your code here.
        return search(array, 0, array.length - 1);
    }
    private static int search(int[] array, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < mid) return search(array, mid + 1, end);
            else if (mid == array[mid] && mid == 0) return mid;
            else if (mid == array[mid] && array[mid - 1] < (mid - 1)) return mid;
            else return search(array, start, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-5,-3,2,3,4,5,9};
        System.out.println(indexEqualsValue(a));
    }
}
