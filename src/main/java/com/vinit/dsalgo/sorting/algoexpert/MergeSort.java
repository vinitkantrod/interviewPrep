package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        merge(array, 0, array.length - 1);
        return array;
    }

    public static void merge(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) / 2;
        merge(array, left, mid);
        merge(array, mid + 1, right);
        array = join(array, left, mid, right);
    }

    public static int[] join(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            a2[i] = array[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                array[k] = a1[i];
                i++;
            } else {
                array[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = a1[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = a2[j];
            j++;
            k++;
        }
        return array;
    }


    public static void main(String args[]) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}
