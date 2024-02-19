package com.vinit.dsalgo.algoexpert.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        // Write your code here.
        int N = array.size();
        int M = 0;
        for (int i = 0; i < array.size(); i++) M = Math.max(M, array.get(i));
        int bits = 1;
        for (; M / bits > 0;bits *= 10)
            countSort(array, N, bits);
        return array;
    }

    private static void countSort(ArrayList<Integer> array, int N, int bits) {
        int[] countArr = new int[10];
        int i;
        int[] outputArr = new int[N];
        Arrays.fill(countArr, 0);
        for (i = 0; i < N; i++) countArr[(array.get(i) / bits) % 10]++;
        for (i = 1; i < 10; i++) countArr[i] += countArr[i - 1];
        for (i = N - 1; i >=0; i--) {
            outputArr[countArr[(array.get(i) / bits) % 10] - 1] = array.get(i);
            countArr[(array.get(i) / bits) % 10]--;
        }
        for (i = 0; i < N; i++) array.set(i, outputArr[i]);
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(170,45,75,90,802,24,2,66));
        System.out.println(List.of(radixSort(a)));
    }
}
