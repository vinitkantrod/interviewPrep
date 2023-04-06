package com.vinit.dsalgo.challenges.gfg;

import java.util.Arrays;

public class EqualLeftAndRightSubArray {

    public static int equalSum(int [] A, int N) {
        //Write your code here
        int[] prefixArray = new int[N];
        Arrays.fill(prefixArray, 0);
        int[] suffixArray = new int[N];
        Arrays.fill(suffixArray, 0);
        prefixArray[0] = A[0];
        suffixArray[N - 1] = A[N - 1];
        for (int i = 1, j = 1; i < N; i++) {
            prefixArray[i] = prefixArray[i - 1] + A[i];
        }
//        System.out.println(Arrays.toString(prefixArray));
        for (int j = N - 2; j > 0; j--) {
            suffixArray[j] = suffixArray[j + 1] + A[j];
        }
//        System.out.println(Arrays.toString(suffixArray));
        for (int i = 0; i < N; i++) {
            if (prefixArray[i] == suffixArray[i]) return i + 1; // Array is 1 based index
        }
        return  -1;
    }
    public static void main(String[] args) {
//        int[] A = {1,4,2,5};
        int[] A = {1,3,5,2,2};
        System.out.println(equalSum(A, A.length));
    }
}
