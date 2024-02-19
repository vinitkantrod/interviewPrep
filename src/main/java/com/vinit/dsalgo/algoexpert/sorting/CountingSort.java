package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;

public class CountingSort {

    public static int[] countingSort(int[] arr) {
        int N = arr.length;
        int M = 0;
        for (int i = 0; i < N; i++) M = Math.max(M, arr[i]);
        int[] countArr = new int[M + 1];
        for (int i = 0; i < N; i++) countArr[arr[i]]++;
        for (int i = 1; i <= M; i++) countArr[i] += countArr[i - 1];
        int[] outputArr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            outputArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }
        return outputArr;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,5,3,0,10,2,3,0,3};
        System.out.println(Arrays.toString(countingSort(a)));
    }
}
