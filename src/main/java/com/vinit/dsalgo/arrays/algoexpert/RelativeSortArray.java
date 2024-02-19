package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;
import java.util.Map;

public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int N = arr1.length;
        int M = arr2.length;
        int[] output = new int[N];
        int max = 0;
        int i;
        for (i = 0; i < arr1.length; i++) max = Math.max(max, arr1[i]);
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);
        for (i = 0; i < N; i++) count[arr1[i]]++;
        int k = 0;
        System.out.println(Arrays.toString(count));
        for (i = 0; i < M; i++) {
            while (count[arr2[i]] > 0) {
                output[k++] = arr2[i];
                count[arr2[i]]--;
            }
        }
        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(count));
        for (i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                output[k++] = i;
                count[i]--;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] b = new int[]{2,42,38,0,43,21};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(relativeSortArray(a, b)));
    }
}
